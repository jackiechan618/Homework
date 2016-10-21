void setup(){
  float sum = 0, a = 0, b = 0;
  for(int i = 1; i <= 100; i++){
    sum += i;
  }
  println("1+2+3+...+100=", sum);
  println();
  
  for(int i = 1; i <= 100; i++){
    a += 1/(i*1.0);
    b += 1/(101-i*1.0);
  }
  println("1/1 + 1/2 + ... + 1/100 = ", a);
  println("1/100 + 1/99 + ... + 1/1 = ", b);
  println("a - b = ", a-b);
  println();
  
  a = b = 0;
 
  for(float i = 1; i <= 100; i++){
    a += 1/i;
    b += 1/(101-i);
  }
  println("1/1 + 1/2 + ... + 1/100 = ", a);
  println("1/100 + 1/99 + ... + 1/1 = ", b);
  println("a - b = ", a-b);
}

