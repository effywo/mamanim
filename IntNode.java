/**
 * node object for node list practice
 *
 * @author effywo
 * @version 03.06.19.001
 *
 */
public class IntNode {

    private int _value;
    private IntNode _next;

    public IntNode() {
        _value=0;
        _next=null;
    }

    public IntNode(int value,IntNode next){
        _value=value;
        _next=next;
    }

    public IntNode(int value){
        _value=value;
        _next=null;
    }

    public void setValue(int value){
        _value=value;
    }

    public int getValue(){
        return _value;
    }

    public void setNext(IntNode next){
        _next=next;
    }

    public IntNode getNext(){
        return _next;
    }
}
