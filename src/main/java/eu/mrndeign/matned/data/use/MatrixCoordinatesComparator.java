package eu.mrndeign.matned.data.use;

import java.util.Comparator;

public class MatrixCoordinatesComparator implements Comparator<MatrixCoordinates> {


    @Override
    public int compare(MatrixCoordinates o1, MatrixCoordinates o2) {
        if (o1.getZ() > o2.getZ()){
            return 1;
        }else if(o1.getZ() < o2.getZ()){
            return -1;
        }else{
            if (o1.getY() > o2.getY()){
               return -1;
            }else if(o1.getY() < o2.getY()){
               return 1;
            }else{
                return Integer.compare(o1.getX(), o2.getX());
            }
        }
    }
}
