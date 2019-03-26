public class Calculator{
    /*Evaluate a postfix expression stored in s.
     *Assume valid postfix notation, separated by spaces.
     */
    public static double eval(String s){
      MyDeque<Double> deque = new MyDeque<Double>();
      String[] data = s.split(" ");
      for(int i =0; i < data.length; i++){
        //System.out.println(data[i]);
        if(data[i].equals("*")){
          //System.out.println("hi" + deque.removeLast());
          double x = deque.removeLast();
          double y = deque.removeLast();
          //System.out.println(x);
          //System.out.println(y);
          deque.addLast(x*y);
        }
        else if(data[i].equals("+")){
          double x = deque.removeLast();
          double y = deque.removeLast();
          deque.addLast(x+y);
        }
        else if(data[i].equals("-")){
          double x = deque.removeLast();
          double y = deque.removeLast();
          deque.addLast(y-x);
        }
        else if(data[i].equals("/")){
          double x = deque.removeLast();
          double y = deque.removeLast();
          deque.addLast(y/x);
        }
        else if(data[i].equals("%")){
          double x = deque.removeLast();
          double y = deque.removeLast();
          deque.addLast(y%x);
        }
        else{
          deque.addLast(Double.parseDouble(data[i]));
          //System.out.println(deque.toString());
        }
      }
      return deque.removeLast();
    }
    public static void main(String[] args){
      System.out.println("5 7 *");
      System.out.println(Calculator.eval("5 7 *"));
    }
}
