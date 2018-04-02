package calculation;

import java.util.Arrays;

public class Overlap {
    int [] overlapCoordinates;
    int [] firstRectangular;
    int [] seconfRectangular;

    public Overlap(int[] allCoordinates) {
        this.overlapCoordinates = new int [4];
        this.firstRectangular = Arrays.copyOfRange(allCoordinates, 0, 4);
        this.seconfRectangular = Arrays.copyOfRange(allCoordinates, 4, 8);
    }

    public Integer calculateOverlap(){
        int overlapArea = 0;
        if(!checkIfNotOverlaping()){
            claculateOverlapCoordinates();
            overlapArea = calculateOverlapArea();
        }
        return overlapArea;
    }

    private boolean checkIfNotOverlaping(){
        return  (firstRectangular[0] > seconfRectangular[2]) ||
                (firstRectangular[1] > seconfRectangular[3]) ||
                (firstRectangular[2] < seconfRectangular[0]) ||
                (firstRectangular[3] < seconfRectangular[1]);
    }

    private int getCoordinateCloserToZero(int firstCoordinate, int secondCoordinate){
        return Math.abs(firstCoordinate) < Math.abs(secondCoordinate)? firstCoordinate : secondCoordinate;
    }

    private void claculateOverlapCoordinates(){

        for(int i = 0; i < overlapCoordinates.length; ++i){
            overlapCoordinates[i] = getCoordinateCloserToZero(firstRectangular[i], seconfRectangular[i]);
        }
    }

    private int calculateOverlapArea(){
        int width = overlapCoordinates[0] - overlapCoordinates[2];
        int height = overlapCoordinates[1] - overlapCoordinates[3];

        return Math.abs(width) * Math.abs(height);
    }
}
