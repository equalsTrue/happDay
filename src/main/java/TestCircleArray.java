

public class TestCircleArray {


    public static void main(String[] args){

    }


    /**
     * 环形队列
     */
    class CircleArray{

        private int maxSize;

        private int front;

        private int rear;

        private int[] array;

        public CircleArray(int arraySize){

            this.maxSize = arraySize;

            this.array = new int[maxSize];
        }

        /**
         * 判断是队列是否满
         * @return
         */
        public boolean isFull(){
            boolean isFull = false;
            if((rear + 1) % maxSize == front){
                isFull = true;
            }
            return isFull;
        }

        public  boolean isEmpty(){
            boolean isEmpty = false;
            if(rear == front){
                isEmpty = true;
            }
            return isEmpty;
        }


        /**
         * 添加队列
         * @param value
         * @return
         */
        public void addQueue(int value){
            if(isFull()){
                System.out.println("队列已满，请勿添加数据");
                return ;
            }else {
                array[rear] = value;
                rear = (rear + 1) % maxSize;
            }
        }

        public int getQueue(){
            int value;
            if(isEmpty()){
                System.out.println("队列为空,取不出值");
                throw new RuntimeException();
            }else {
                value = array[front];
                front = (front + 1) % maxSize;
            }
            return value;
        }

        public void showQueue(){
            if(isEmpty()){
                System.out.println("队列无数据");
                return;
            }else {
                for(int i = front; i< front + size(); i ++){

                }
            }
        }

        public int size(){
            int size = (rear + maxSize - front ) % maxSize;
            return size;
        }

    }

}
