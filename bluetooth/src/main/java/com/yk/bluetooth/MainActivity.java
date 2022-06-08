package com.yk.bluetooth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothGatt;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.clj.fastble.BleManager;
import com.clj.fastble.callback.BleGattCallback;
import com.clj.fastble.callback.BleScanCallback;
import com.clj.fastble.data.BleDevice;
import com.clj.fastble.exception.BleException;
import com.clj.fastble.scan.BleScanRuleConfig;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Ble> bleList = new LinkedList<>();
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.BleRew);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        BleAdapter adapter = new BleAdapter(bleList);
        recyclerView.setAdapter(adapter);

        BleManager.getInstance().init(getApplication());
        BleManager.getInstance()
                .enableLog(true)
                .setReConnectCount(1, 5000)
                .setOperateTimeout(5000);

    }


    public void isSupportBle(View view) {
        boolean b = BleManager.getInstance().isSupportBle();
        if (b) {
            Toast.makeText(this, "该设备支持蓝牙", Toast.LENGTH_LONG).show();
            return;
        }
        Toast.makeText(this, "该设备不支持蓝牙", Toast.LENGTH_LONG).show();
    }

    public void isBlueEnable(View view) {
        boolean b = BleManager.getInstance().isBlueEnable();
        if (b) {
            Toast.makeText(this, "蓝牙已开", Toast.LENGTH_LONG).show();
            return;
        }
        Toast.makeText(this, "蓝牙未开", Toast.LENGTH_LONG).show();
    }

    public void enableBluetooth(View view) {
        boolean b = BleManager.getInstance().isBlueEnable();
        if (!b) {
            BleManager.getInstance().enableBluetooth();
            Toast.makeText(this, "蓝牙已打开", Toast.LENGTH_LONG).show();
            return;
        }
    }

    public void enableDirBluetooth(View view) {
        Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivityForResult(intent, 0x01);
        Toast.makeText(this, "请确认是否打开蓝牙", Toast.LENGTH_LONG).show();

    }

    public void ConfigScan(View view) {
        BleScanRuleConfig scanRuleConfig = new BleScanRuleConfig.Builder()
                .setScanTimeOut(10000)
                .build();
        BleManager.getInstance().initScanRule(scanRuleConfig);
        BleManager.getInstance().scan(new BleScanCallback() {
            @Override
            public void onScanFinished(List<BleDevice> scanResultList) {
                Toast.makeText(MainActivity.this, "扫描结束", Toast.LENGTH_LONG).show();
                for (int i = 0; i < scanResultList.size(); i++) {
                    Ble ble = new Ble();
                    ble.setName(scanResultList.get(i).getName());
                    ble.setMac(scanResultList.get(i).getMac());
                    ble.setKey(scanResultList.get(i).getKey());
                    bleList.add(ble);
                }
            }

            @Override
            public void onScanStarted(boolean success) {
                Toast.makeText(MainActivity.this, "开始扫描" + success, Toast.LENGTH_LONG).show();

            }

            @Override
            public void onScanning(BleDevice bleDevice) {

                Toast.makeText(MainActivity.this, "扫描中" + bleDevice.getName(), Toast.LENGTH_LONG).show();
                BleManager.getInstance().connect(bleDevice, new BleGattCallback() {
                    @Override
                    public void onStartConnect() {
                        Toast.makeText(MainActivity.this,"开始连接",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onConnectFail(BleDevice bleDevice, BleException exception) {
                        Toast.makeText(MainActivity.this,"连接失败",Toast.LENGTH_LONG).show();

                    }

                    @Override
                    public void onConnectSuccess(BleDevice bleDevice, BluetoothGatt gatt, int status) {

                        Toast.makeText(MainActivity.this,"连接成功",Toast.LENGTH_LONG).show();

                    }

                    @Override
                    public void onDisConnected(boolean isActiveDisConnected, BleDevice device, BluetoothGatt gatt, int status) {

                        Toast.makeText(MainActivity.this,"断开连接",Toast.LENGTH_LONG).show();

                    }
                });

            }
        });


    }
}