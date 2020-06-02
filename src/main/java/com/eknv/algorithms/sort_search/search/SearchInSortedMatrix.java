package com.eknv.algorithms.sort_search.search;


import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.util.Assert;

/**
 * Given an n x n matrix and a number x, find the position of x in the matrix if it is present in it.
 * <p>
 * In the given matrix, every row and column is sorted in increasing order.
 * The designed algorithm should have linear time complexity.
 * <p>
 * Preferred implementation
 */
public class SearchInSortedMatrix {

    private SearchInSortedMatrix() {
    }

    public static Coordinate execute(int[][] matrix, int searchValue) {

        Assert.notNull(matrix, "Matrix cannot be null");

        return execute(matrix, matrix.length, matrix[0].length, searchValue);
    }

    private static Coordinate execute(int[][] matrix, int rows, int columns, int searchValue) {

        /**
         * set indexes for top right
         * if match return position
         * if the searchValue is bigger, then moven a row down
         * if the searchValue is smaller than the current value, then move a column back
         * continue till a result is find or we reach the matrix boundaries
         */
        int rowIndex = 0;
        int columnIndex = columns - 1;

        while (rowIndex < rows && columnIndex >= 0) {
            if (matrix[rowIndex][columnIndex] == searchValue) {
                return new Coordinate(rowIndex, columnIndex);
            } else if (matrix[rowIndex][columnIndex] > searchValue) {
                columnIndex--;
            } else { // if mat[i][j] < x
                rowIndex++;
            }
        }

        return null;
    }

    public static class Coordinate {
        private int x;
        private int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public boolean equals(Object obj) {

            if (!(obj instanceof Coordinate)) {
                return false;
            }

            Coordinate other = (Coordinate) obj;

            return new EqualsBuilder()
                    .append(this.getX(), other.getX())
                    .append(this.getY(), other.getY())
                    .isEquals();
        }

        @Override
        public int hashCode() {
            return new HashCodeBuilder().append(getX()).append(getY()).toHashCode();
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.NO_CLASS_NAME_STYLE).
                    append("X", getX()).append("Y", getY()).toString();
        }
    }

}
