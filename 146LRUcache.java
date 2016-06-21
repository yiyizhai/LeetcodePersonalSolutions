public class LRUCache {
    //have a capacity
    //have a size
    //key, value pair ==> create our own class
    //the most recent get/set one -> special position
    //the least used one --> special position(get and remove it when size > capacity)
    //we need to get one very quickly: hashmap
    
    class Nodes{
        int key;
        int value;
        Nodes(int k, int v){
            key = k;
            value = v;
        }
    }
    int capacity;
    int size;
    HashMap<Integer, Nodes> map;
    LinkedList<Nodes> queue;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<Integer, Nodes>();
        queue = new LinkedList<Nodes>();
        size = 0;
    }
    
    //check the hashmap
    //not find it: return -1
    //find it: return the value && move the node to the end of the queue
    public int get(int key) {
        int value = -1;
        if(map.containsKey(key)){
            value = map.get(key).value;
            queue.remove(map.get(key));
            queue.add(map.get(key));
        }
        
        return value;
    }
    
    //check exists or not?
    //yes: change the original value and move it to the tail
    //no: check capacity?
    //there's still space: insert a new node to the queue and map
    //there's no space: poll the node from the head, remove corresponding one form the map
    //                  insert new one to the tail, add it to the map
    public void set(int key, int value) {
        if(map.containsKey(key)){
            Nodes node = map.get(key);
            node.value = value;
            queue.remove(node);
            queue.add(node);
        }else{
            size++;
            if(this.capacity < size){
                Nodes remove = queue.remove();
                map.remove(remove.key);
                size--;
            }
            Nodes node = new Nodes(key, value);
            map.put(key, node);
            queue.add(node);
        }
    }
}
