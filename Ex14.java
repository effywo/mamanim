public class Ex14 {

    public static int solutions(int num){
        if(num<3||num>30){
            return 0;
        }
        //int x1,x2,x3;
        //return 1+ solution(num,x1,x2,x3);


        return 1;
    }

    private static int solution(int num, int x1, int x2, int x3){
        if(num==1){
            return 0;
        }
        return 1 + solution(num-1,x1,x2,x3);
    }

    /**
     * returns the amount of water the array can accept as a bucket
     * time complexity = O(n), memory complexity O(1).
     * @param heights array to calculate its water capacity
     * @return the water capacity of the array
     */
    public static int waterVolume(int[] heights){
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
     * @param a array to check its
     * @return the the length of the longest sub array that its sum is even
     */
    public static int what(int a[]){
        //original method time complexity of O(n^3) for every sub array O(n^2) f()calculates the sum O(n)total of O(n^3)
        //the method returns the longest sub array that its sum is even
        //time complexity = O(n) n to find sum of the given array, n to find the
        // first odd sum from the two ends then returns the length minus i is the
        // longest sub array =O(2n)which is O(n)
        //memory complexity = O(1) all variables created are constant(sum, i,i)
        int sum=0;
        for (int i=0;i<a.length;i++){
            sum+=a[i];
        }
        if (sum%2==0)
            return a.length;
        for (int i=0;i<a.length/2;i++){
            if(a[i]%2!=0||a[a.length-i-1]%2!=0) {
            // if ((a[i]+a[a.length-1-i])%2!=0){
                    return a.length-i-1;
                }
        }
        if(a.length%2!=0){
            //if the array has odd amount of elements and the middle is an odd number
            // then the longest array is the length divided by 2 (rounded down)
            return a.length/2;
        }
        return 0;
    }

}

