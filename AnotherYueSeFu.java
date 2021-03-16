package Test;

public class AnotherYueSeFu {
    public static void main(String[] args) {
        CircleList list = new CircleList();
        list.yuesefu(12,6);
    }
}
//用无额外的头节点来实现约瑟夫环
/*
    约瑟夫环
    给定一个n,从1开始数到n,当有人数到特定的数时,将被退出链表
    这n个数形成环
 */
class Node{
     int data;
     Node next;
    public Node(int data,Node next){
        this.data = data;
        this.next = next;
    }
}
class CircleList{
    private Node head ;
    private Node tail ;
    private int size ;
    private Node temp = null;

    //对于环进行插入
    public void insert(Node node){
        if (size==0){
            head = node;
            tail = node;
        }else{
            tail.next = node ;
            node.next = head ;
            tail = node;
        }
        size++;
    }
    public void  yuesefu(int total,int index){
        
        //对环形链表的每一个节点进行标号
        for (int i = 1; i <= total ; i++) {
            Node node = new Node(i,null);
            this.insert(node);
        }
        Node t = head;
        while (this.size>0){
            int i = this.remove(t,index);
            //让t节点指向已经删除了的节点的下一个
            t = this.temp;
            System.out.println(i);
        }
    }

    //对当前的节点进行遍历，找到这之后删除index次数后的节点，并返回值
    public int remove(Node node,int index){

        //找到要删除的节点得的前一个节点
        for (int i = 1;i<index-1;i++){
            node = node.next;
        }
        //得到值
        int n = node.next.data;
        //删除
        if(size!=1){
            node.next = node.next.next;
            node = node.next;
        }else{
            node = null;
            head = null;
            tail = null;
        }
        size--;
        //用于保存删除节点的下一个节点
        temp = node;
        return n;
    }
        
}

