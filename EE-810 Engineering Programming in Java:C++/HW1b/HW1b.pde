void setup(){
  for(int i = 0; i < 10; i++){
    print(i);
    println();
  }
  
  /*homework 1b*/
  for(int i = 1; i <= 99; i+=2){
    print(i);
    println();
  }
  
  
  for(int i = 0; i <= 32768; i+=2){
    if(i == 0){
      print("1");
      println();
    }
    else{
      print(i);
      println();
    }
  }
  
  exit();
}
