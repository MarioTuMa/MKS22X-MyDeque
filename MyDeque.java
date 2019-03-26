import java.util.NoSuchElementException;
//import java.util.NullPointerException;
public class MyDeque<E>{
  private E[] data;
  private int size, start, end, elements;

  public MyDeque(){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[10];
    data = d;
    start = 0;
    end = 0;
    elements = 0;
    size = 10;
  }
  public MyDeque(int initialCapacity){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[initialCapacity];
    data = d;
    start = 0;
    end = 0;
    elements = 0;
    size = initialCapacity;
  }
  public int size(){
    //System.out.println(start);
    //System.out.println("hi");
    return elements;
  }
  public String toString(){
    String toReturn = "{";
    if(start <= end){
      //System.out.println(start);
      //System.out.println(end);
      for(int i = Integer.valueOf(start); i < Integer.valueOf(end); i ++){
        toReturn += (data[i]).toString()+" ";
      }
      // if(toReturn.length()>1){
      //   toReturn = toReturn.substring(0,toReturn.length()-1);
      // }

      toReturn += "}";
      return toReturn;
    }
    else{
      for(int i = Integer.valueOf(start); i < size; i ++){
        toReturn +=(data[i]).toString()+" ";
      }
      //System.out.println("\n" + Integer.toString(end));
      for(int i = 0; i < Integer.valueOf(end); i ++){
        toReturn += (data[i]).toString()+" ";
      }
      //toReturn = toReturn.substring(0,toReturn.length()-1);
      toReturn += "}";
      return toReturn;
    }
  }
  private void grow(){
    E[] newData = (E[])new Object[size * 2];

    //System.out.println("starting grow");
    if(start < end){

      for(int i = Integer.valueOf(start); i < Integer.valueOf(end); i ++){
        newData[i]=data[i];
      }

      String old = "";
      for(int i = 0; i < data.length; i ++){
        old += data[i] +", ";
      }
      //System.out.println(old);
      String news = "";
      for(int i = 0; i < data.length; i ++){
        news += data[i] +", ";
      }
      //System.out.println(news);
      data = newData;
    }
    else{
      int counter = 0;
      for(int i = Integer.valueOf(start); i < size; i ++){
        newData[counter] = data[i];
        counter++;
      }

      for(int i = 0; i < Integer.valueOf(end); i ++){
        newData[counter] = data[i];
        counter++;
      }
      String old = "";
      for(int i = 0; i < data.length; i ++){
        old += data[i] +", ";
      }
      //System.out.println(old);
      String news = "";
      for(int i = 0; i < data.length; i ++){
        news += data[i] +", ";
      }
      //System.out.println(news);
      data = newData;
      start = 0;
      end = counter;
    }
    size *= 2;
    //System.out.println("ending grow");

  }
  public void addFirst(E element){

    if(element == null){
      throw new NullPointerException();
    }

    if(start == 0){
      start = size - 1;
    }
    else{
      start--;
    }
    data[start] = element;
    elements++;
    if(elements +  1 == size){
      grow();

    }
   }
  public void addLast(E element){
    //System.out.print(element);
    if(element == null){
      throw new NullPointerException();
    }
    data[end] = element;
    //System.out.print(element);
    if(end == size - 1){
      end = 0;
    }
    else{
      end++;
    }

    elements++;
    if(elements == size){
      grow();

    }
  }
  public E removeFirst(){

    if(elements == 0){
      throw new NoSuchElementException();
    }
    elements--;
    //E toReturn = data[start];
    if(start == size - 1){
      start = 0;
      return data[size - 1];
    }
    else{

      start ++;
      return data[(start-1+size)%size];
    }


  }
  public E removeLast(){
    //System.out.print(end);

    if(elements == 0){
      throw new NoSuchElementException();
    }
    elements--;
    if(end>=1){
      end--;
      return data[end];
    }
    else{
      end = size - 1;
      return data[end];
    }


  }
  public E getFirst(){
    if(elements == 0){
      throw new NoSuchElementException();
    }
    return data[start];
  }
  public E getLast(){
    if(elements == 0){
      throw new NoSuchElementException();
    }
    return data[(end-1+size)%size];
  }
  public static void main(String args[]){
    // MyDeque deque = new MyDeque<>();
    //
    // for (int i = 0; i < 1000; i++) {
    //
    //
		// 		deque.addFirst(i);
    //
    //
		// }
		// System.out.println(deque.toString());
		// //System.out.println(comp.toString());
		// // removing from front without wrap
		// System.out.println("175");
		// for (int i = 0; i < 1000; i++) {
		// 	try {
		// 		deque.removeFirst();
    //
    //     System.out.println(deque.start);
    //
		// 	} catch (Exception e) {
    //     System.out.println(deque.start);
		// 		System.out.println(deque.toString());
    //     System.out.println(deque.start);
		// 		//System.out.println(comp.toString());
		// 		System.out.println(Integer.toString(deque.size()));
		// 		//System.out.println(Integer.toString(comp.size()));
		// 		System.out.println(Integer.toString(deque.elements));
		// 		//System.out.println(message(old+".removeFirst()", gist_string(comp), e.toString()));
		// 		break;
		// 	}
		// }
  }
}
