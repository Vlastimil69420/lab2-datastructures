/**
 * Lab2 - ListReferenceBasedTest
 * Tests the reference-based implementation of the ADT List.
 * Exercises isEmpty, size, add, get, remove, removeAll, and
 * listLongest, using displayList() to print the list after
 * each change so the ADT operations can be visually confirmed.
 *
 * @author Vlastimil Finger (B00176858)
 */
public class ListReferenceBasedTest
{
  public static void main(String[] args)
  {
    ListReferenceBased list = new ListReferenceBased();
    // test isEmpty, size and listLongest on a new list
    System.out.println("isEmpty: " + list.isEmpty());          // true
    System.out.println("size: " + list.size());                // 0
    list.displayList();                                        // List: []
    System.out.println("listLongest: " + list.listLongest());  // null (empty list)
    // test add
    list.add(1, "Apple");
    list.add(2, "Banana");
    list.add(3, "Cherry");
    list.displayList();                                        // List: [Apple, Banana, Cherry]
    // test size and isEmpty again, now that the list has items
    System.out.println("size: " + list.size());                // 3
    System.out.println("isEmpty: " + list.isEmpty());          // false
    // test get
    System.out.println("get(1): " + list.get(1));              // Apple
    System.out.println("get(2): " + list.get(2));              // Banana
    System.out.println("get(3): " + list.get(3));              // Cherry
    // test listLongest
    System.out.println("listLongest: " + list.listLongest());  // Banana (ties with Cherry, first one wins)
    // test remove
    list.remove(2);                                            // removes "Banana"
    list.displayList();                                        // List: [Apple, Cherry]
    System.out.println("listLongest: " + list.listLongest());  // Cherry
    // test add at the front, in the middle and at the end
    list.add(1, "Kiwi");
    list.add(3, "Strawberry");
    list.add(5, "Fig");
    list.displayList();                                        // List: [Kiwi, Apple, Strawberry, Cherry, Fig]
    System.out.println("listLongest: " + list.listLongest());  // Strawberry
    // test remove at the front and at the end
    list.remove(1);                                            // removes "Kiwi"
    list.remove(4);                                            // removes "Fig"
    list.displayList();                                        // List: [Apple, Strawberry, Cherry]
    // test that invalid indexes throw ListIndexOutOfBoundsException
    try
    {
      list.get(0);
    }
    catch (ListIndexOutOfBoundsException e)
    {
      System.out.println("get(0): " + e.getMessage());
    }
    try
    {
      list.add(5, "Plum");
    }
    catch (ListIndexOutOfBoundsException e)
    {
      System.out.println("add(5): " + e.getMessage());
    }
    try
    {
      list.remove(4);
    }
    catch (ListIndexOutOfBoundsException e)
    {
      System.out.println("remove(4): " + e.getMessage());
    }
    // test removeAll
    list.removeAll();
    list.displayList();                                        // List: []
    System.out.println("isEmpty: " + list.isEmpty());          // true
    System.out.println("listLongest: " + list.listLongest());  // null (empty list)
  }
}
