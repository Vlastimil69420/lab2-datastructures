/**
 * Lab2 - ListReferenceBasedTest
 * Tests the reference-based implementation of the ADT List.
 * Exercises isEmpty, size, add, get, remove, and removeAll,
 * using displayList() to print the list after each change so
 * the ADT operations can be visually confirmed.
 *
 * @author Vlastimil Finger (B00176858)
 */
public class ListReferenceBasedTest
{
  public static void main(String[] args)
  {
    ListReferenceBased list = new ListReferenceBased();
    // test isEmpty and size on a new list
    System.out.println("isEmpty: " + list.isEmpty());          // true
    System.out.println("size: " + list.size());                // 0
    list.displayList();                                        // List: []
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
    // test remove
    list.remove(2);                                            // removes "Banana"
    list.displayList();                                        // List: [Apple, Cherry]
    // test removeAll
    list.removeAll();
    list.displayList();                                        // List: []
    System.out.println("isEmpty: " + list.isEmpty());          // true
  }
}
