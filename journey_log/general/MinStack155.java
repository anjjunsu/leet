import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Pair {
    Integer val;
    Integer min;

    public Pair(Integer val, Integer min) {
        this.val = val;
        this.min = min;
    }

    public Integer getVal() {
        return val;
    }

    public Integer getMin() {
        return min;
    }
}

class MinStack {
    Stack <Pair > s;

    public MinStack() {
        s = new Stack<>();
    }
    
    public void push(int val) {
        if (s.empty()) {
            Pair entry = new Pair(val, val);
            s.push(entry);
        } else {
            if (s.peek().getMin() > val) {
                Pair entry = new Pair(val, val);
                s.push(entry);
            } else {
                Pair entry = new Pair(val, s.peek().getMin());
                s.push(entry);
            }
        }
    }
    
    public void pop() {
       s.pop(); 
    }
    
    public int top() {
       return s.peek().getVal(); 
    }
    
    public int getMin() {
        return s.peek().getMin();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */