final int n = 20;
int mouse_x = 0, mouse_y = 0, temp_x = 0, temp_y = 0,
    count = 0, drag_flag = 0, lock_drag = 0, color_drag = 0;
int[][] a = new int[n][n]; // a[i][j] = 1 means the rect[i][j] has the chess, a[i][j] = 0 means it does have. 
int[][] b = new int[n][n]; // b[i][j] = 1 means the color of a[i][j] is red, b[i][j] = 0 means the color is green. 

int check_x(){
  if(mouseX - mouseX / (width/n) * (width/n) < (width/n/3) )
    return mouseX / (width/n);
  if(mouseX - mouseX / (width/n) * (width/n) > (width/n/3*2) )
    return mouseX / (width/n) + 1;
  else
    return 0;
}

int check_y(){
  if(mouseY - mouseY / (height/n) * (height/n) < (height/n/3) )
    return mouseY / (height/n);
   if(mouseY - mouseY / (height/n) * (height/n) > (height/n/3*2) )
    return mouseY / (height/n) + 1;
   else
    return 0;
}

void setup(){
  size(700,700);
  for(int i = 0; i < n; i++){
    for(int j = 0; j < n; j++){
      a[i][j] = b[i][j] = 0;
    }
  }
}

void draw(){
  background(255,204,153); 
  for(int i = 1; i < n; i++){
    for(int j = 1; j < n; j++){
      stroke(0);
      line(i*width/n, height/n, i*width/n, height-height/n);
      line(width/n, j*height/n, width-width/n, j*height/n);
    }
  }
  
  for(int i = 0; i < n; i++){
    for(int j = 0; j < n; j++){
    
      if(a[i][j] == 1)
      {
        if(b[i][j] == 1){
          fill(0); 
          stroke(0);
          ellipse(i*width/n, j*height/n, width/n/2, height/n/2);
        }
        else if(b[i][j] == 2){
          fill(255);
          stroke(255);
          ellipse(i*width/n, j*height/n, width/n/2, height/n/2);
        } 
      }
    }  
  }
  
  if(drag_flag == 1){
    if(color_drag == 1){
      fill(0);
      stroke(0);
      ellipse(mouse_x, mouse_y, width/n/2, height/n/2);
    }
    else if(color_drag == 2){
      fill(255);
      stroke(255); 
      ellipse(mouse_x, mouse_y, width/n/2, height/n/2); 
    }   
  }  
}

void mousePressed(){
  if( (mouseX >= width/n) && (mouseX <= width-width/n) && (mouseY >= height/n) && (mouseY <= height-height/n)){
    int x = 0, y = 0;
    
    x = check_x();
    y = check_y();
    if(x != 0 && y != 0){
      temp_x = x;
      temp_y = y;
      lock_drag = 1;
      
      if(a[x][y] == 0){
        a[x][y] = 1;
        count++;
        if(count % 2 == 1)
          b[x][y] = 1;
        else
          b[x][y] = 2;
      }   
      color_drag = b[x][y];
    }
  }
}

void mouseDragged(){
   if( (mouseX >= width/n) && (mouseX <= width-width/n) && (mouseY >= height/n) && (mouseY <= height-height/n)){
     mouse_x = mouseX;
     mouse_y = mouseY;
     int x = 0, y = 0;
    
     x = check_x();
     y = check_y();
     if(x != 0 && y != 0){
       drag_flag = 1;      
       if( (a[x][y] == 1) && (lock_drag == 1) ){
       a[x][y] = 0;
       lock_drag = 0;
       }
     }
   }
}

void mouseReleased(){
   if( (mouseX >= width/n) && (mouseX <= width-width/n) && (mouseY >= height/n) && (mouseY <= height-height/n)){
     int x = 0, y = 0;
    
     x = check_x();
     y = check_y();
     if(x != 0 && y != 0){
       if(drag_flag == 1){
         drag_flag = 0;
         if(a[x][y] == 0){
           if( ( x != temp_x) || (y != temp_y) ){
             a[x][y] = 1;
             b[x][y] = b[temp_x][temp_y];
             a[temp_x][temp_y] = 0;
             b[temp_x][temp_y] = 0;
           }
           else a[temp_x][temp_y] = 1;
         }
         else a[temp_x][temp_y] = 1;
        }
     }
     else{ 
       a[temp_x][temp_y] = 1;
       drag_flag = 0;
     }
   } 
}
