class MyCalendarThree {
    Map<Integer,Integer>map;

    public MyCalendarThree() {
        map=new TreeMap<Integer,Integer>();
        
    }
    
    public int book(int startTime, int endTime) {
        int bookings=0,max=0;
        map.put(startTime,map.getOrDefault(startTime,0)+1);
        map.put(endTime,map.getOrDefault(endTime,0)-1);
        for(Map.Entry<Integer,Integer>entry:map.entrySet()){
            bookings=bookings+entry.getValue();
            max=Math.max(max,bookings);
        }
        return max;
        
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(startTime,endTime);
 */