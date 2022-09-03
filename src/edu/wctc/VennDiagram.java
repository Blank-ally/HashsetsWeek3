package edu.wctc;

import java.util.HashSet;
import java.util.Set;

public class VennDiagram<T> {

    String label1, label2, label3;
    Set<T> set1 = new HashSet<>();
    Set<T> set2 = new HashSet<>();
    Set<T> set3 = new HashSet<>();

    public VennDiagram(String label1, String label2, String label3) {

        this.label1 = label1;
        this.label2 = label2;
        this.label3 = label3;

    }

    private Set<T> getCircleForLabel(String Label) {

        if (Label.equals(label1)) {
            return set1;

        } else if (Label.equals(label2)) {
            return set2;
        } else if (Label.equals(label3)) {
            return set3;
        } else return null;
    }

    public void add(T item, String... labels) {

        for (int i = 0; i < labels.length; i++) {
            if (labels[i] == label1) {
                set1.add(item);
            } else if (labels[i] == label2) {

                set2.add(item);

            } else if (labels[i] == label3) {
                set3.add(item);
            }
        }


    }


    public Set<T> unionOf(String first, String second) {
        Set<T> union = new HashSet<>();
        if (first == label1) {
            union.addAll(set1);

        } else if (first == label2) {
            union.addAll(set2);

        } else if (first == label3) {
            union.addAll(set3);

        }
        if (second == label1) {
            union.addAll(set1);

        } else if (second == label2) {
            union.addAll(set2);

        } else if (second == label3) {
            union.addAll(set3);

        }

        return union;

    }

    public Set<T> intersectionOf (String first, String second) {

        Set<T> intersection = new HashSet<>();
        if (first == label1) {
            intersection.addAll(set1);


        } else if (first == label2) {
            intersection.addAll(set2);


        } else if (first == label3) {
            intersection.addAll(set3);
        }
        if (second == label1) {
            intersection.retainAll(set1);


        } else if (second == label2) {
            intersection.retainAll(set2);


        } else if (second == label3) {
            intersection.retainAll(set3);


        }


        return intersection;
    }
      public Set <T> complementOf(String first, String second) {
          Set<T> complement = new HashSet<>();
          if (first == label1) {
              complement.addAll(set1);


          } else if (first == label2) {
              complement.addAll(set2);


          } else if (first == label3) {
              complement.addAll(set3);
          }
          if (second == label1) {
              complement.removeAll(set1);


          } else if (second == label2) {
              complement.removeAll(set2);


          } else if (second == label3) {
              complement.removeAll(set3);


          }
          return complement;
      }


    public Set <T> diagramCenter() {
        Set<T>  center = new HashSet<>();

        center.addAll(set1);
        center.retainAll(set2);
        center.retainAll(set3);

        return center;
    }
}
