class MyStack {

    public ArrayList<Integer> arr;

    public MyStack() {
        this.arr= new ArrayList<>();    
    }
    
    public void push(int x) {
        this.arr.add(x);   
    }
    
    public int pop() {
        return this.arr.remove(this.arr.size()-1);
    }
    
    public int top() {
        return this.arr.get(this.arr.size()-1);
    }
    
    public boolean empty() {
        return this.arr.size()==0?true:false;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */