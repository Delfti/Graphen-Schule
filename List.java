public class List<ContentType> {
  private class ListNode {
    private ContentType contentObject;
    private ListNode next;

    private ListNode(ContentType pContent) {
      contentObject = pContent;
      next = null;
    }

    public ContentType getContentObject() {
      return contentObject;
    }

    public void setContentObject(ContentType pContent) {
      contentObject = pContent;
    }

    public ListNode getNextNode() {
      return next;
    }

    public void setNextNode(ListNode pNext) {
      next = pNext;
    }
  }

  private ListNode first;
  private ListNode last;
  private ListNode current;
  private int length;

  public List() {
    first = null;
    last = null;
    current = null;
    length = 0;
  }

  public boolean isEmpty() {
    return length == 0;
  }

  public boolean hasAccess() {
    return current != null;
  }

  public void next() {
    if (current != null) {
      current = current.getNextNode();
    }
  }

  public void toFirst() {
    current = first;
  }

  public void toLast() {
    current = last;
  }

  public ContentType getContent() {
    return hasAccess() ? current.getContentObject() : null;
  }

  public void setContent(ContentType pContent) {
    if (hasAccess() && pContent != null) {
      current.setContentObject(pContent);
    }
  }

  public void insert(ContentType pContent) {
    if (pContent != null) {
      ListNode newNode = new ListNode(pContent);

      if (hasAccess()) {
        if (current == first) {
          newNode.setNextNode(first);
          first = newNode;
        } else {
          ListNode prev = getPrevious(current);
          prev.setNextNode(newNode);
          newNode.setNextNode(current);
        }
      } else {
        if (isEmpty()) {
          first = newNode;
          last = newNode;
        }
      }
      length++;
    }
  }

  public void append(ContentType pContent) {
    if (pContent != null) {
      ListNode newNode = new ListNode(pContent);
      if (isEmpty()) {
        first = newNode;
        last = newNode;
      } else {
        last.setNextNode(newNode);
        last = newNode;
      }
      length++;
    }
  }

  public void concat(List<ContentType> pList) {
    if (pList != null && !pList.isEmpty() && pList != this) {
      if (isEmpty()) {
        first = pList.first;
        last = pList.last;
      } else {
        last.setNextNode(pList.first);
        last = pList.last;
      }
      length += pList.length; // Länge aktualisieren
      pList.first = null;
      pList.last = null;
      pList.current = null;
      pList.length = 0;
    }
  }

  public void remove() {
    if (hasAccess()) {
      if (current == first) {
        first = first.getNextNode();
      } else {
        ListNode previous = getPrevious(current);
        if (current == last) {
          last = previous;
        }
        previous.setNextNode(current.getNextNode());
      }
      current = current.getNextNode();
      length--;

      if (isEmpty()) {
        last = null;
      }
    }
  }

  private ListNode getPrevious(ListNode pNode) {
    if (pNode != null && pNode != first) {
      ListNode temp = first;
      while (temp != null && temp.getNextNode() != pNode) {
        temp = temp.getNextNode();
      }
      return temp;
    }
    return null;
  }

  public boolean isIn(ContentType pContent) {
    if (pContent == null) {
      return false;
    }

    ListNode temp = first;
    while (temp != null) {
      if (temp.getContentObject().equals(pContent)) {
        return true;
      }
      temp = temp.getNextNode();
    }
    return false;
  }

  public ContentType get(int pIndex) {
    if (pIndex < 0 || pIndex >= length) {
      return null;
    }

    ListNode temp = first;
    for (int i = 0; i < pIndex; i++) {
      temp = temp.getNextNode();
    }
    return temp.getContentObject();
  }

  public void removeAt(int index) {
    if (index < 0 || index >= length) {
      return;
    }

    if (index == 0) {
      first = first.getNextNode();
      if (first == null) {
        last = null;
      }
    } else {
      ListNode temp = first;
      for (int i = 0; i < index - 1; i++) {
        temp = temp.getNextNode();
      }

      if (temp.getNextNode() == last) {
        last = temp;
      }
      temp.setNextNode(temp.getNextNode().getNextNode());
    }
    length--;
  }

  public int size() {
    return length;
  }
}