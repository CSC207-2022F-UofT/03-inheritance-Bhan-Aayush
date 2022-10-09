/*
 * This file defines an abstract class named Bag.
 * In this exercise, you will be writing a larger class according to
 * the TODOs we have left you. You may find the readings in chapter
 * 1. Introduction to Java helpful.
 */

public abstract class Bag {

    private String color;

    private int numberOfContents;
    private int capacity;
    private String[] contents;

    /*
     */


    /*

     *
     * The other attributes (private instance variables) should
     * be empty (e.g. numberOfContents is 0 and an empty String array for
     * its contents.)
     */

      public Bag(String color, int capacity){
          this.color = color;
          this.capacity = capacity;
          this.numberOfContents = 0;
          this.contents = new String[this.capacity];
      }


    /*

     */
       public String getColor() {
           return this.color;
       }

       public int getNumberofContents(){
           return this.numberOfContents;
       }

       public int getCapacity() {
           return this.capacity;
       }


    /*

     */
        public void setColor(String newColor) {
            this.color = newColor;
        }




    /*
     *
     *       This method should return true if the item was added
     *       and false otherwise.
     */
      public boolean addItem(String item) {
          if (this.contents[this.contents.length - 1] == null) {
              for (int i = 0; i < this.contents.length; i++) {
                  if (this.contents[i] == null) {
                      this.contents[i] = item;
                      this.numberOfContents = this.numberOfContents + 1;
                      return true;
                  }
              }
          } return false;
      }



    /**
     * If there are no items in this Bag, return null.
     *
     * @return
     */
     public String popItem() {
         if (this.numberOfContents == 0) {
             return null;
         }
         String popped = this.contents[this.numberOfContents - 1];
         this.contents[this.numberOfContents - 1] = null;
         this.numberOfContents = this.numberOfContents - 1;
         return popped;

     }




    /**
     * Increase this bag's capacity by n.
     *
     * @param n the amount to increase this Bag's capacity by
     */
    public void increaseCapacity(int n) {
        // TODO: Implement this method.
          this.capacity = this.capacity + n;

          String[] temp = new String[this.capacity];

          for (int i = 0; i < this.contents.length; i++){
              temp[i] = this.contents[i];
          }

          this.contents = temp;
    }

    /**
     * Return the details of this Bag.
     * This method requires you to have created the private
     * instance variables mentioned above.
     *
     * @return
     */
    @Override
    public String toString() {
        return this.color + " Bag (" + this.numberOfContents + " / " +
                this.capacity + ")";
    }

    /*
     * Below we have defined an abstract method.
     * This method takes no arguments and does not return anything.
     * It increases the capacity of this Bag.
     *
     * You will need to implement this method in
     * HandBag.java and CrossbodyBag.java.
     *
     * We recommend you look at HandBag.java first.
     */
    public abstract void enhance();
}