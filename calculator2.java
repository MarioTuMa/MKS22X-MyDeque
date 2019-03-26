public class Calculator2{
    /*Evaluate a postfix expression stored in s.
     *Assume valid postfix notation, separated by spaces.
     */
    public static double eval(String s){
      MyDeque<Double> deque = new MyDeque<Double>();
      String[] data = s.split(" ");
      for(int i =0; i < data.length; i++){
        //System.out.println(data[i]);
        if(data[i].equals("*")){
          //System.out.println("hi" + deque.removeFirst());
          double x = deque.removeFirst();
          double y = deque.removeFirst();
          //System.out.println(x);
          //System.out.println(y);
          deque.addFirst(x*y);
        }
        else if(data[i].equals("+")){
          double x = deque.removeFirst();
          double y = deque.removeFirst();
          deque.addFirst(x+y);
        }
        else if(data[i].equals("-")){
          double x = deque.removeFirst();
          double y = deque.removeFirst();
          deque.addFirst(y-x);
        }
        else if(data[i].equals("/")){
          double x = deque.removeFirst();
          double y = deque.removeFirst();
          deque.addFirst(y/x);
        }
        else if(data[i].equals("%")){
          double x = deque.removeFirst();
          double y = deque.removeFirst();
          deque.addFirst(y%x);
        }
        else{
          deque.addFirst(Double.parseDouble(data[i]));
          //System.out.println(deque.toString());
        }
      }
      return deque.removeFirst();
    }
    public static void main(String[] args){
      System.out.println("5 7 *");
      System.out.println(Calculator.eval("5 7 *"));
    }
}
