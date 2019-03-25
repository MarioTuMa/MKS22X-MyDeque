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
    return elements;
  }
  public String toString(){
    String toReturn = "{";
    if(start <= end){

      for(int i = start; i < end; i ++){
        toReturn += (data[i]).toString()+" ";
      }
      toReturn += "}";
      return toReturn;
    }
    else{
      for(int i = start; i < size; i ++){
        toReturn +=(data[i]).toString()+" ";
      }
      for(int i = 0; i < end; i ++){
        toReturn += (data[i]).toString()+" ";
      }
      toReturn += "}";
      return toReturn;
    }
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
   }
  public void addLast(E element){
    System.out.print(element);
    if(element == null){
      throw new NullPointerException();
    }
    System.out.print(element);
    if(end == size - 1){
      end = 0;
    }
    else{
      end++;
    }
    data[end] = element;
    elements++;
  }
  public E removeFirst(){
    if(elements == 0){
      throw new NoSuchElementException();
    }
    E toReturn = data[start];
    if(start == size - 1){
      start = 0;
    }
    else{
      start --;
    }
    elements--;
    return data[start];
  }
  public E removeLast(){
    if(elements == 0){
      throw new NoSuchElementException();
    }
    E toReturn = data[end];
    if(end>1){
      end--;
    }
    else{
      end = size - 1;
    }
    elements--;
    return toReturn;
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
    return data[end];
  }
  public static void main(String args[]){
    MyDeque md = new MyDeque();
    System.out.println(md.toString());
    md.addFirst(4);
    System.out.println(md.toString());
    md.addLast(5);
    System.out.println(md.toString());
    md.removeLast();
    System.out.println(md.toString());
    md.removeLast();
    System.out.println(md.toString());
  }
}
