class MyCalendarTwo {
    Map<Integer,Integer>counts;


    public MyCalendarTwo() {
        counts=new TreeMap<Integer,Integer>();
    }
    
    public boolean book(int startTime, int endTime) {
        counts.put(startTime,counts.getOrDefault(startTime,0)+1);
        counts.put(endTime,counts.getOrDefault(endTime,0)-1);
        int bookings=0;
        for(Map.Entry<Integer,Integer>entry:counts.entrySet()){
           bookings=bookings+entry.getValue();
           if(bookings>2){
            counts.put(startTime,counts.get(startTime)-1);
            counts.put(endTime,counts.get(endTime)+1);
            return false;
           }
        }
        return true;

    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(startTime,endTime);
 */