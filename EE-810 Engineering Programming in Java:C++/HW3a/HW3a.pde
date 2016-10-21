final int n = 12;
int mouse_x = 0, mouse_y = 0, 
    temp_x = 0, temp_y = 0,
    count = 0, 
    drag_flag = 0, lock_drag = 0, color_drag = 0;
int[][] a = new int[n][n]; // a[i][j] = 1 means the rect[i][j] has the chess, a[i][j] = 0 means it does have. 
int[][] b = new int[n][n]; // b[i][j] = 1 means the color of a[i][j] is red, b[i][j] = 0 means the color is green. 

void setup(){
  size(800,800);
  for(int i = 0; i < n; i++){
    for(int j = 0; j < n; j++){
      a[i][j] = b[i][j] = 0;
    }
  }
}

void draw(){
  for(int i = 0; i < n; i++){
    for(int j = 0; j < n; j++){
      if( (i+j) % 2 == 0 ) fill(0);
      else fill(255);
      rect(width/n*i, height/n*j, width/n, height/n);
    
      if(a[i][j] == 1)
      {
        if(b[i][j] == 1){
          fill(255, 0, 0); 
          stroke(255, 0, 0);
          ellipse(i*width/n+width/n/2, j*height/n+width/n/2, width/n/2, height/n/2);
        }
        else if(b[i][j] == 2){
          fill(0, 255, 0);
          stroke(0, 255, 0);
          ellipse(i*width/n+width/n/2, j*height/n+width/n/2, width/n/2, height/n/2);
        } 
        stroke(0);
      }
    }  
  }
  
  if(drag_flag == 1){
    if(color_drag == 1){
      fill(255,0,0);
      stroke(255, 0, 0);
      ellipse(mouse_x, mouse_y, width/n/2, height/n/2);
    }
    else if(color_drag == 2){
      fill(0,255, 0);
      stroke(0, 255, 0); 
      ellipse(mouse_x, mouse_y, width/n/2, height/n/2); 
    }
    stroke(0);    
  }  
}

void mousePressed(){
  temp_x = mouseX;
  temp_y = mouseY;
  lock_drag = 1;
  
  if(a[mouseX / (width/n)][mouseY / (height/n)] == 0){
    a[mouseX / (width/n)][mouseY / (height/n)] = 1;
    count++;
    if(count % 2 == 1)
     b[mouseX / (width/n)][mouseY / (height/n)] = 1;
    else
     b[mouseX / (width/n)][mouseY / (height/n)] = 2;
  }   
  color_drag = b[temp_x / (width/n)][temp_y / (height/n)];
}

void mouseDragged(){
  mouse_x = mouseX;
  mouse_y = mouseY;
  drag_flag = 1;

  if( (a[mouse_x / (width/n)][mouse_y / (height/n)] == 1) && (lock_drag == 1) ){
    a[mouse_x / (width/n)][mouse_y / (height/n)] = 0;
    lock_drag = 0;
  }
}

void mouseReleased(){
  drag_flag = 0;
  if(a[mouseX / (width/n)][mouseY / (height/n)] == 0){
    if( ( mouseX / (width/n) != temp_x / (width/n) ) || ( mouseY / (height/n) != temp_y / (height/n) ) ){
      a[mouseX / (width/n)][mouseY / (height/n)] = 1;
      b[mouseX / (width/n)][mouseY / (height/n)] = b[temp_x / (width/n)][temp_y / (height/n)];
      a[temp_x / (width/n)][temp_y / (height/n)] = 0;
      b[temp_x / (width/n)][temp_y / (height/n)] = 0; 
    }
    else a[temp_x / (width/n)][temp_y / (height/n)] = 1;
  }
  else a[temp_x / (width/n)][temp_y / (height/n)] = 1; 
}
