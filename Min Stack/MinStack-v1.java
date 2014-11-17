class MinStack {
    Stack<Integer> list = new Stack<Integer>();
    Stack<Integer> min = new Stack<Integer>();
    public void push(int x) {
        list.add(x);
        if (!min.isEmpty() && min.peek() >= x) {
            min.add(x);
        } else if (min.isEmpty()) {
            min.add(x);
        }
    }

    public void pop() {
        if (!list.isEmpty()) {
            if (list.pop().equals(min.peek())) {
                min.pop();
            }
        }
    }

    public int top() {
        if (!list.isEmpty()) {
            return list.peek();
        }
        return 0;
    }

    public int getMin() {
        if (!min.isEmpty()) {
            return min.peek();
        }
        return 0;
    }
}
