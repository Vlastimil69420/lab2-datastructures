/**
 * Lab2 - ListReferenceBasedTest
 * Tests the reference-based implementation of the ADT List.
 * Exercises isEmpty, size, add, and get.
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
    // test add
    list.add(1, "Apple");
    list.add(2, "Banana");
    list.add(3, "Cherry");
    // test size and isEmpty again, now that the list has items
    System.out.println("size: " + list.size());                // 3
    System.out.println("isEmpty: " + list.isEmpty());          // false
    // test get
    System.out.println("get(1): " + list.get(1));              // Apple
    System.out.println("get(2): " + list.get(2));              // Banana
    System.out.println("get(3): " + list.get(3));              // Cherry
  }
}
