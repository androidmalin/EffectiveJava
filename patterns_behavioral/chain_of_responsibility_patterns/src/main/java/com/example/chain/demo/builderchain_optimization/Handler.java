package com.example.chain.demo.builderchain_optimization;

public abstract class Handler<N> {
    protected Handler<N> next;

    private void next(Handler<N> next) {
        this.next = next;
    }

    public abstract void doHandler(N t);

    public static class Builder<T> {
        private Handler<T> head;
        private Handler<T> tail;

        public Builder<T> addHandler(Handler<T> handler) {
            if (this.head == null) {
                this.head = this.tail = handler;
                return this;
            }
            this.tail.next(handler);
            this.tail = handler;
            return this;
        }

        public Handler<T> build() {
            return this.head;
        }
    }
}
