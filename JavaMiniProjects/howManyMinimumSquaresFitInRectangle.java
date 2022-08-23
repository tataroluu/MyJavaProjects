public int howMuchSquare(int numHight, int numWidth){
        ArrayList arl =new ArrayList<>();

              while (true)
        {

            if (numWidth<numHight){
                numHight=numHight-numWidth;
                arl.add(numHight);
             }
            else if (numHight<numWidth){
                numWidth= numWidth-numHight;
                arl.add(numWidth);
             }
            else if (numHight==numWidth){
                arl.add(numHight);
                 break;
            } 
        } 
        
              return arl.size();
    }