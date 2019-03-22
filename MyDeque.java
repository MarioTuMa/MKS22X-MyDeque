public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  public MyDeque(){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[10];
    data = d;
  }
  public MyDeque(int initialCapacity){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[initialCapacity];
    data = d;
    start = 0;
    end = 1;
  }
  public int size(){
    if(end<start){
      return size + end - start;
    }
    else{
      return start - end;
    }
  }
  public String toString(){
    String toReturn = "{";
    if(start < end){

      for(int i = start; i < end + 1; i ++){
        toReturn += (data[i]).toString()+" ";
      }
      toReturn += "}";
      return toReturn;
    }
    else{
      for(int i = start; i < size; i ++){
        toReturn += data[i];
      }
      for(int i = 0; i < end; i ++){
        toReturn += data[i];
      }
      toReturn += "}";
      return toReturn;
    }
  }
  public void addFirst(E element){
    if(start == 0){
      start = size - 1;
    }
    else{
      start--;
    }
    data[start] = element;
   }
  public void addLast(E element){
    if(end == size - 1){
      end = 0;
    }
    else{
      end++;
    }
    data[end] = element;
  }
  public E removeFirst(){
    E toReturn = data[start];
    if(start == size - 1){
      start = 0;
    }
    else{
      start --;
    }
    return data[start];
  }
  public E removeLast(){
    if(end>1){
      end--;
    }
    else{
      end = size - 1;
    }
    return data[end];
  }
  public E getFirst(){
    return data[start];
  }
  public E getLast(){
    return data[end-1];
  }
}
