package com.yk.bluetooth;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BleAdapter extends RecyclerView.Adapter<BleAdapter.ViewHolder> {
    private List<Ble> bleList;

    public BleAdapter(List<Ble> bleList) {
        this.bleList = bleList;
    }

    /**
     * Called when RecyclerView needs a new {@link ViewHolder} of the given type to represent
     * an item.
     * <p>
     * This new ViewHolder should be constructed with a new View that can represent the items
     * of the given type. You can either create a new View manually or inflate it from an XML
     * layout file.
     * <p>
     * The new ViewHolder will be used to display items of the adapter using
     * {@link #onBindViewHolder(ViewHolder, int, List)}. Since it will be re-used to display
     * different items in the data set, it is a good idea to cache references to sub views of
     * the View to avoid unnecessary {@link View#findViewById(int)} calls.
     *
     * @param parent   The ViewGroup into which the new View will be added after it is bound to
     *                 an adapter position.
     * @param viewType The view type of the new View.
     * @return A new ViewHolder that holds a View of the given view type.
     * @see #getItemViewType(int)
     * @see #onBindViewHolder(ViewHolder, int)
     */
    @NonNull
    @Override
    public BleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //onCreateViewHolder() 方法是用于创建ViewHolder 实例的， 我们在这个方法中将item_Fruit 布局加载进来， 然后创建一个ViewHolder 实例， 并把加载出来的布局传入到构造函数当中， 最后将ViewHolder 的实例返回。
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adatpter, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the {@link ViewHolder#itemView} to reflect the item at the given
     * position.
     * <p>
     * Note that unlike {@link ListView}, RecyclerView will not call this method
     * again if the position of the item changes in the data set unless the item itself is
     * invalidated or the new position cannot be determined. For this reason, you should only
     * use the <code>position</code> parameter while acquiring the related data item inside
     * this method and should not keep a copy of it. If you need the position of an item later
     * on (e.g. in a click listener), use {@link ViewHolder#getAdapterPosition()} which will
     * have the updated adapter position.
     * <p>
     * Override {@link #onBindViewHolder(ViewHolder, int, List)} instead if Adapter can
     * handle efficient partial bind.
     *
     * @param holder   The ViewHolder which should be updated to represent the contents of the
     *                 item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //onBindViewHolder() 方法是用于对RecyclerView子项的数据进行赋值的， 会在每个子项被滚动到屏幕内的时候执行， 这里我们通过position 参数得到当前项的Fruit实例， 然后再将数据设置到ViewHolder 的ImageView和TextView当中即可。
        Ble ble = bleList.get(position);

        holder.name.setText(ble.getName());
        holder.mac.setText(ble.getMac());
        holder.device.setText(ble.getDevice().toString());
        holder.ScanRecord.setText(ble.getScanRecord().toString());
        holder.key.setText(ble.getKey());
        holder.rssi.setText(ble.getRssi());
        holder.timestampNanos.setText(ble.getTimestampNanos() + "");

    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return bleList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView mac;
        TextView device;
        TextView ScanRecord;
        TextView key;
        TextView rssi;
        TextView timestampNanos;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            mac = itemView.findViewById(R.id.mac);
            device = itemView.findViewById(R.id.device);
            ScanRecord = itemView.findViewById(R.id.ScanRecord);
            key = itemView.findViewById(R.id.key);
            rssi = itemView.findViewById(R.id.rssi);
            timestampNanos = itemView.findViewById(R.id.timestampNanos);

        }
    }
}
