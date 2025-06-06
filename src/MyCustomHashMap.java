import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyCustomHashMap<K, V>
{
    private class Entry<K, V>
    {
        private final K key;
        private V value;
        private Entry<K, V> next;

        public Entry(K key, V value)
        {
            this.key = key;
            this.value = value;
        }

        public K getKey()
        {
            return this.key;
        }

        public V getValue()
        {
            return this.value;
        }

        public void setValue(V value)
        {
            this.value = value;
        }

        @Override
        public String toString()
        {
            var temp = this;
            var stringBuilder = new StringBuilder();
            while (temp != null)
            {
                stringBuilder.append(temp.key + " -> " + temp.value + ",");
                temp = temp.next;
            }
            return stringBuilder.toString();
        }
    }

    private final int SIZE = 5;
    private Entry<K, V> table[];

    public MyCustomHashMap()
    {
        table = new Entry[SIZE];
    }

    public void put(K key, V value)
    {
        var hash = key.hashCode() % SIZE;
        var entry = table[hash];

        if (entry == null)
        {
            table[hash] = new Entry<K, V>(key , value);
        }
        else
        {
            while(entry.next != null)
            {
                if(entry.getKey() == key)
                {
                    entry.setValue(value);
                    return;
                }
                entry = entry.next;
            }

            if(entry.getKey() == key)
            {
                entry.setValue(value);
                return;
            }
            entry.next = new Entry<K, V>(key, value);
        }
    }

    public V get(K key)
    {
        var hash = key.hashCode() % SIZE;
        var entry = table[hash];

        if(entry == null)
        {
            return null;
        }

        while(entry != null)
        {
            if(entry.getKey() == key)
            {
                return entry.getValue();
            }
            entry = entry.next;
        }

        return null;
    }

    public Entry<K, V> remove(K key)
    {
        var hash= key.hashCode() % SIZE;
        var entry = table[hash];

        if(entry == null)
        {
            return null;
        }

        if(entry.getKey() == key)
        {
            table[hash] = entry.next;
            entry.next = null;
            return entry;
        }

        var prev = entry;
        entry.next = null;

        while (entry != null)
        {
            if(entry.getKey() == key)
            {
                prev.next = entry.next;
                entry.next = null;
                return entry;
            }
            prev = entry;
            entry = entry.next;
        }

        return null;
    }

    @Override
    public String toString()
    {
        var sb = new StringBuilder();
        for (int i = 0; i < SIZE; i++)
        {
            if (table[i] != null)
            {
                sb.append(i + " " + table[i] + "\n");
            }
            else
            {
                sb.append(i + " " + "null" + "\n");
            }
        }

        return sb.toString();
    }
}
