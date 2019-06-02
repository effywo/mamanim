/**
 * Maman 14, answer to questions 1-4
 *
 * @author effywo
 * @version 01.06.2019.04
 */
public class Ex14 {

    /**
     *  Prints all possible variations of "x1+x2+x3=num" num is the given number, where x is 10 or less
     * @param num to print all possibilities for the equation
     * @return the amount of variations possible
     */
    public static int solutions(int num){
        //ANSWER TO QUESTION 3:
        //if num is less then 3 then equation is not possible
        //if num is greater then 30 then equation must include x greater then 10 which isn't valid
        if(num<3||num>30){
            return 0;
        }
        //defining variables
        int x1=1,x2 =1,x3=1;int count=0; //count is the counter for all equation matches found
        //recursive method call to loop through all x possibilities
        return solutions(count,num,x1,x2,x3);
    }

    private static int solutions(int count,int num, int x1, int x2, int x3) {
        //private method to be called from public override method
        //recursive method that checks for the amount of variations of "x1+x2+x3=mun" where x is less then 10
        //the method loops through all x1+x2+x3 to check if the match num if match found prints the equation and adds up counter
        //count to hod the count of solutions found, num the given number to check, x1,x2,x3 x values to check equations
        //checking if a equation match is found

        if (x1 + x2 + x3 == num) {
            //printing the equation and add to counter
            System.out.println(x1 + "+" + x2 + "+" + x3);
            count++;}
        if (x3 < 10) { //adding 1 to x1 value until 10 is reached
            x3 += 1;
            return solutions(count, num, x1, x2, x3);//recursive call with the new value of x1
        } else { // if reached 10 then resets x1 and moves on to x2
            x3 = 1;
        }
        if (x2 < 10) { //adding 1 to x2 until 10 is reached
            x2 += 1;
            return solutions(count, num, x1, x2, x3); //recursive call with new x2 value to loop through all x1 values possible
        } else { //if 10 is reached resets x2 on moves on to x3
            x2 = 1;
        }
        if (x1 < 10) { //add 1 to x3 until 10 is reached
            x1 += 1;
            return solutions(count, num, x1, x2, x3); // recursive call with new x3 value to loop through all x1 and x2 values possible
        }//when 10 is reached the solutions is found and returns the counter
        return count;
    }

    /**
     * returns the amount of water the array can accept as a bucket
     * time complexity = O(n), memory complexity O(1).
     * @param heights array to calculate its water capacity
     * @return the water capacity of the array
     */
    public static int waterVolume(int[] heights){
        //ANSWER TO QUESTION 1:
        //to calculate the amount of water the bucket can hold first find the highest point ofthe bucket
        //then start from the right wall and add all point that are less then the wall when the point is larger then the wall
        //then the wall is updated to the new high wall and continues to add point less then the wall till it gets to the highestpoint
        //then starts at the left wall and does the same as from the right wall till it gets to the highstpoint and then returns the total points
        //of capacity.

        int totalCapacity=0;
        int rightWall = heights[0];
        int leftWall=heights[heights.length-1];

        //looping the array to find the highest point
        int highestPoint=0;
        for(int i=1;i<heights.length;i++){
            if(heights[i]>heights[highestPoint]){
                highestPoint=i;
            }
        }

        //looping from the right wall till the highest point and adding all points that can hold the water
        for(int i=1; i<highestPoint;i++){
            //if the point is less then the right wall then it can hold water
            if(heights[i]<rightWall){
                totalCapacity+=(rightWall-heights[i]);
            }else { //if the point is equals or bigger then the wall then it becomes the new wall and no points are added
                rightWall=heights[i];
            }
        }
        //looping from the left till the highest point and adding all points that can hold water
        for(int i=heights.length-2;i>highestPoint;i--){
            //if the point is less then the left wall then it can hold water
            if(heights[i]<leftWall){
                totalCapacity+=(leftWall-heights[i]);
            } else { //if the point is equals or bigger the the wall then it becomes the new wall
                leftWall=heights[i];
            }
        }
        //finally returning the total of both half's of the highest point to a total of points that can hold water
        return totalCapacity;
    }

    /**
     * returns the length of the longest sub array that its sum is even
     * original method time complexity of O(n^3) for every sub array O(n^2) f()calculates the sum O(n)total of O(n^3)
     * original method memory complexity of O(1) Explained: int C is defined inside the double loop but overwritten everytime.
     * the method returns the longest sub array that its sum is even
     * final method time complexity = O(n) explained:
     * n to find sum of the given array a[], n to find the first odd number from the two ends then returns the length minus i which is the
     * longest sub array =O(2n)which is considered O(n)
     * final method memory complexity = O(1) all variables created are constant(sum, i,i)
     * @param a array to check for its longest sub array that its sum is even
     * @return the length of the longest sub array that its sum is even
     */
    public static int what(int a[]){
        //ANSWER TO QUESTION 2:

        //Summing up the array to check if it's sum is even
        int sum=0;
        for (int i=0;i<a.length;i++){
            sum+=a[i];
        }
        if (sum%2==0)//if sum is even then the longest even sub array is the full array
            return a.length;

        for (int i=0;i<a.length/2;i++){
            if(a[i]%2!=0||a[a.length-i-1]%2!=0) {//checking both ends till an odd number found the returns the length minus 1 of the index.  
                return a.length-i-1;
            }
        }
        //extra test because used < and not >.
        if(a.length%2!=0){
            //if the array has odd amount of elements and the middle is an odd number
            // then the longest array is the length divided by 2 (rounded down)
            return a.length/2;
        }
        return 0;
    }

    /**
     * checks a matrix for a path that sums to the given number <br> 
     * where path can move only right, left, up, and down.<br>
     * return true if found, false otherwise.<br>
     * a matrix named path is used to indicate the path used by using 1 value<br>
     * if path not found then matrix path will have all values set to 0.
     * @param   mat the matrix to check
     * @param   sum the given sum to check for
     * @param   path the matrix that shows the path used to get the sum
     * @return true if path was found
     */
    public static boolean findSum (int mat[][], int sum, int path[][]){
        //ANSWER TO QUESTION 4:
        //calling recursive method with default index
        return findSum(mat,sum,path,0,0);
    }

    private static boolean findSum(int mat[][],int sum,int path[][],int row,int col) {
        //loops the matrix for starting point
        //then calls method pathFound to check if theres a path found for the sum
        if (pathFound(mat, sum, path, row, col,0)) { //if method pathFound return true then returns true and solution was found
            return true;
        } else if (col == mat[0].length - 1) {//move starting point index to next in the line, if starting point got to the end of the line moves to next line
            col = 0;
            row++;
        } else {
            col++;
        }
        if (row == mat.length) { //if index got to line out of the matrix returns false, no solution was found
            return false;
        }
        return findSum(mat,sum,path,row,col);//recursive call to next starting point index
    }

    private static boolean pathFound(int mat[][],int sum, int path[][],int row, int col, int pathSum){
        //checks if path is found from given index moving right,left,down, and up.
        //marks path[row][col] to 1 as is part of the path sollution
        if(row<0||row>=mat.length||col<0||col>=mat[0].length||path[row][col]==1)//checks for valid indexes, and the path[row][col] was not mark 1 to not enter same index twice
            return false;
        path[row][col]=1; // set 1 in the path
        pathSum+=mat[row][col];// and mat[row][col] to pathSum value to check with sum
        boolean result;//holds false if theres not part of the path
        if(pathSum==sum)//if pathSum = sum sollution found and returns true
            return true;
        if(pathSum>sum)//if pathSum greater them sum matrix in index not part of the path, sets result to false
            result=false;
            //otherwise recursive call to the method in all directions id any call returns true then solution was found, return true.
        else if(pathFound(mat,sum,path,row,col+1,pathSum)||pathFound(mat,sum,path,row,col-1,pathSum)
                ||pathFound(mat,sum,path,row+1,col,pathSum)||pathFound(mat,sum,path,row-1,col,pathSum)){
            return true;
        } else{//no call returns true,mat in index not part of the path, set result to false.
            result = false;
        }
        if(!(result)){//if result = false sets path in index to 0, to indicate its not part of the path subtracts value of mat in inex from pathSum
            path[row][col]=0;
            pathSum-=mat[row][col];
        }
        return false;// if code got to this line then returns false
    }

}
