package com.dacompany.dadrip.dummy;

import android.bluetooth.BluetoothDevice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Data {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<Item> ITEMS = new ArrayList<Item>();

    /**
     * A map of items; String = device ID, Item = device object
     */
    public static final Map<String, Item> ITEM_MAP = new HashMap<String, Item>();

    private static final int COUNT = 25;

    public static void addItem(BluetoothDevice device) {
        Item dev = new Item(device);
        ITEMS.add(dev);
        ITEM_MAP.put(device.getAddress(), dev);
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class Item {
        BluetoothDevice device;

        public Item(BluetoothDevice device) {
            this.device = device;
        }

        @Override
        public String toString() {
            return String.format("%s:%s", device.getAddress(), device.getName());
        }

        public BluetoothDevice getDevice() {
            return device;
        }
    }
}