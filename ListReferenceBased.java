// ****************************************************
// Reference-based implementation of ADT list.
// ****************************************************

/**
 * Lab2 - ListReferenceBased
 * Reference-based implementation of the ADT List,
 * extended with displayList() and listLongest().
 *
 * @author Vlastimil Finger (B00176858)
 */
public class ListReferenceBased implements ListInterface
{
  // reference to linked list of items
  private Node head;
  private int numItems; // number of items in list

  public ListReferenceBased()
  {
    numItems = 0;
    head = null;
  }  // end default constructor

  public boolean isEmpty()
  {
    return numItems == 0;
  }  // end isEmpty

  public int size()
  {
    return numItems;
  }  // end size

  private Node find(int index)
  {
  // --------------------------------------------------
  // Locates a specified node in a linked list.
  // Precondition: index is the number of the desired
  // node. Assumes that 1 <= index <= numItems+1
  // Postcondition: Returns a reference to the desired
  // node.
  // --------------------------------------------------
    Node curr = head;
    for (int skip = 1; skip < index; skip++)
    {
      curr = curr.getNext();
    } // end for
    return curr;
  } // end find

  public Object get(int index) throws ListIndexOutOfBoundsException
  {
    if (index >= 1 && index <= numItems)
    {
      // get reference to node, then data in node
      Node curr = find(index);
      Object dataItem = curr.getItem();
      return dataItem;
    }
    else
    {
      throw new ListIndexOutOfBoundsException(
                     "List index out of bounds exception on get");
    } // end if
  } // end get

  public void add(int index, Object item) throws ListIndexOutOfBoundsException
  {
    if (index >= 1 && index <= numItems+1)
    {
      if (index == 1)
      {
        // insert the new node containing item at
        // beginning of list
        Node newNode = new Node(item, head);
        head = newNode;
      }
      else
      {
        Node prev = find(index-1);
        // insert the new node containing item after
        // the node that prev references
        Node newNode = new Node(item, prev.getNext());
        prev.setNext(newNode);
      } // end if
      numItems++;
    }
    else
    {
      throw new ListIndexOutOfBoundsException(
                    "List index out of bounds exception on add");
    } // end if
  }  // end add

  public void remove(int index) throws ListIndexOutOfBoundsException
  {
    if (index >= 1 && index <= numItems)
    {
      if (index == 1)
      {
        // delete the first node from the list
        head = head.getNext();
      }
      else
      {
        Node prev = find(index-1);
        // delete the node after the node that prev
        // references, save reference to node
        Node curr = prev.getNext();
        prev.setNext(curr.getNext());
      } // end if
      numItems--;
    } // end if
    else
    {
      throw new ListIndexOutOfBoundsException(
                   "List index out of bounds exception on remove");
    } // end if
  }   // end remove

  public void removeAll()
  {
    // setting head to null causes list to be
    // unreachable and thus marked for garbage
    // collection
    head = null;
    numItems = 0;
  } // end removeAll

  // Prints the list on one line, e.g. List: [Apple, Banana].
  // Traverses the nodes with curr, without using get() or find().
  public void displayList()
  {
    System.out.print("List: [");
    for (Node curr = head; curr != null; curr = curr.getNext())
    {
      System.out.print(curr.getItem());
      if (curr.getNext() != null)
      {
        System.out.print(", ");
      }
    }
    System.out.println("]");
  }

  // Returns the longest String in the list (the first one if there is a
  // tie) or null if the list is empty. Assumes the items are Strings.
  // Traverses the nodes with curr, without using get() or find().
  public String listLongest()
  {
    String longest = null;
    for (Node curr = head; curr != null; curr = curr.getNext())
    {
      String s = (String) curr.getItem();
      if (longest == null || s.length() > longest.length())
      {
        longest = s;
      }
    }
    return longest;
  }


} // end ListReferenceBased