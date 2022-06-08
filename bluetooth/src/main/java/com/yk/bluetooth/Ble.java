package com.yk.bluetooth;

import android.bluetooth.BluetoothDevice;

import com.clj.fastble.data.BleDevice;

public class Ble {
    private String name;
    private String mac;
    private BluetoothDevice device;
    private byte[] ScanRecord;
    private String key;
    private int rssi;
    private long timestampNanos;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public BluetoothDevice getDevice() {
        return device;
    }

    public void setDevice(BluetoothDevice device) {
        this.device = device;
    }

    public byte[] getScanRecord() {
        return ScanRecord;
    }

    public void setScanRecord(byte[] ScanRecord) {
        this.ScanRecord = ScanRecord;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getRssi() {
        return rssi;
    }

    public void setRssi(int rssi) {
        this.rssi = rssi;
    }

    public long getTimestampNanos() {
        return timestampNanos;
    }

    public void setTimestampNanos(long timestampNanos) {
        this.timestampNanos = timestampNanos;
    }
}
