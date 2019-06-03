/**
 * represents a list of Node from the IntNode class
 *
 * @author effywo
 * @version 03.06.19.001
 */
public class IntNodeList {

    private IntNode _head;

    public IntNodeList(){
        _head=null;
    }

    public IntNodeList(IntNode head){
        _head=head;
    }

    public boolean isEmpty(){
        return _head!=null;
    }

    public void addNodeAtEnd(IntNode node){
        if(isEmpty()){
            _head=node;
        } else {
            IntNode next = _head;
            while(next.getNext()!=null){
                next=next.getNext();
            }//of while
            next.setNext(node);
        }//of if statement
    }//of addNodeAtEnd method

    public void addNodeAtBeginning(IntNode node){
        if(isEmpty()){
            _head=node;
        } else{
            IntNode temp = _head;
            _head=node;
            node.setNext(temp);
        }//of if statement
    }//of addNodeAtBeginning method

    public void addNodeAfterInt(IntNode node,int value){
        if(!isEmpty()){
            if(_head.getValue()==value){
                node.setNext(_head.getNext());
                _head.setNext(node);
            } else {
                IntNode tmpNode=_head;

                while(tmpNode!=null){
                    if(tmpNode.getValue()==value){
                        node.setNext(tmpNode.getNext());
                        tmpNode.setNext(node);
                    }
                }
            }//of if statement
        }//of if empty statement
    }//of method addNodeAfterInt

    public void printList(){
        if(!(isEmpty())){
            IntNode next=_head;
            while (next.getNext()!=null){
                System.out.print(next.getValue()+" > ");
                next=next.getNext();
            }
            System.out.println(next.getValue());
        }
    }
}
