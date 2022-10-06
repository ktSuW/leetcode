/*
    => Singly Linked List
    => Each node consists of data and address of next node
    => if not pointing to the next node, it will be point to null
    
    
    Node                  Node               Node
    Data & address        Data & address     Data & Address
    2      100     --->   42     204    ---> 50      1008   ---> Null 
    
    Each node needs to be created. Therefore we need this class.
    class Node {
        data;
        next;
    }

*/
class Node {
    constructor(val) {
        this.val = val;
        this.next = null;
    }
}

var MyLinkedList = function() {
    this.head = null;
    this.len = 0;
};

MyLinkedList.prototype.get = function(index) {
    if (index >= this.len) return -1;
    
    let curr = this.head;
    
    for (let i = 0; i < index; i++) {
        curr = curr.next;
    }
    
    return curr.val;
};

MyLinkedList.prototype.addAtHead = function(val) {
    const node = new Node(val);
    
    node.next = this.head;
    this.head = node;
    this.len++;
    
    return;
};

MyLinkedList.prototype.addAtTail = function(val) {
    if (this.len == 0) {
        this.addAtHead(val);
        return;
    }
    
    let curr = this.head;
    
    while (curr.next != null) {
        curr = curr.next;
    }
    
    const node = new Node(val);
    
    curr.next = node;
    this.len++;
    
    return;
};

MyLinkedList.prototype.addAtIndex = function(index, val) {
    if (index > this.len) return;
    
    if (index == 0) {
        this.addAtHead(val);
        return;
    }
    
    if (index === this.len) {
        this.addAtTail(val);
        return;
    }
    
    let curr = this.head;
    
    for (let i = 0; i < index - 1; i++) {
        curr = curr.next;
    }
    
    const next = curr.next;
    const node = new Node(val);
    
    curr.next = node;
    node.next = next;
    this.len++;
    
    return;
};

MyLinkedList.prototype.deleteAtIndex = function(index) {
    if (index >= this.len) return;
    
    if (index == 0) {
        this.head = this.head.next;
        this.len--;
        return;
    }
    
    let curr = this.head;
    
    for (let i = 0; i < index - 1; i++) {
        curr = curr.next;
    }
    
    curr.next = curr.next.next;
    this.len--;
    
    return;
};
//====================================================
// 0     1  <= index 
// 1 --> 3  
// 1 --> 2 --> 3 




// // ES6
// // Initialise the Node
// class Node {
//   constructor(val, next) {
//     this.val = val;
//     this.next = null ;
//   }
// }

// // Initializes the MyLinkedList object.
// class MyLinkedList {
//   constructor() {
//     this.head = null;
//     this.len = 0;

//   }
    
// //int get(int index) Get the value of the indexth node in the linked list. 
// // If the index is invalid, return -1.    
//   get(index) {
   
//     if (this.len === 0 || index >= this.len  || index < 0) return -1;

//     let cur = this.head;
//     for (let i = 0; i < index; i++) {
//       cur = cur.next;
//     }
//     return cur.val;
//   }


// // Add a node of value val before the first element of the linked list. 
// // After the insertion, the new node will be the first node of the linked list.
//   addAtHead(val) {
//     const node = new Node(val);
//     node.next = this.head;
//     this.head = node;
//     this.len++;
//     return;
//   };

    
// //  Append a node of value val as the last element of the linked list.
//   addAtTail(val) {
//     if (this.len === 0) {
//       this.addAtHead(val);
//       return;
//     }

//     const node = new Node(val);
//     let cur = this.head;
//     for (let i = 0; i < this.len -1; i++) {
//       cur = cur.next;
//     }
//     cur.next = node;
//     this.len++;
//     return;
//   }

// // Add a node of value val before the indexth node in the linked list. 
// // If index equals the length of the linked list, 
// // the node will be appended to the end of the linked list. 
// // If index is greater than the length, the node will not be inserted. 
//   addAtIndex(index, val) {
//     // Case 3: If index is greater than the length, the node will not inserted.
//     if (index > this.len) return;
//     // Case 1: if the LL is empty, add it to the head
//     if (this.head === null || index === 0) {
//       this.addAtHead(val);
//         // console.log("Add at index len before" , this.len);
//       return;
//     }
            
//     // Case 2: If the LL length is same as index, then add it to the tail
//     if (index === this.len) {
//       this.addAtTail(val);
//       return;
//     }

    
//     // Case 4 : Insert
//     let cur = this.head;
//     const node = new Node(val);

//     for (let i = 0; i < index - 1; i++) {
//       cur = cur.next
//     }
//     let next = cur.next ; 
//     cur.next = node;
//     node.next = next;

//     this.len++;
//     console.log("Add at index len After" , this.len);
//     return;
//   }

// // Delete the indexth node in the linked list, if the index is valid.
//   deleteAtIndex(index) {
//     if (index < 0 || index >= this.len) return;
//     if (index === 0) {
//     // 2 -> 3 -> 5
//     // head      tail
//     // make 3 as head 
//       this.head = this.head.next
//       this.len--;
//       return;
//     }

//     let cur = this.head
//     for (let i = 0; i < index - 1; i++) {
//       cur = cur.next
//     }
//     cur.next = cur.next.next
//     this.len--;
//     return;
//   }
// }

/** 
 * Your MyLinkedList object will be instantiated and called as such:
 * var obj = new MyLinkedList()
 * var param_1 = obj.get(index)
 * obj.addAtHead(val)
 * obj.addAtTail(val)
 * obj.addAtIndex(index,val)
 * obj.deleteAtIndex(index)
 */
