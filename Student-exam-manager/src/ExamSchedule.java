public class ExamSchedule {
    private ExamNode head;
    private ExamNode current;

    public ExamSchedule() {
        this.head = null;
        this.current = null;
    }


    public void addExam(String examDetails) {
        // TODO 2: Implement logic to add an exam to the end of the linked list
        ExamNode newExamNode = new ExamNode(examDetails);
        if(head == null){
            head = newExamNode;
            current = newExamNode;
            System.out.println("Exam added: "+examDetails);
        }else {
            ExamNode node = head;
            while(node.next != null){
                node = node.next;
            }
            node.next = newExamNode;
            newExamNode.prev = node;
            System.out.println("Exam added: "+examDetails);
        }
    }


    public void viewNextExam() {
        if (current == null) {
            System.out.println("No exams available.");
        } else {
            // TODO 3: Implement the logic to move to the next exam in the list and displays it
            System.out.println("Next Exam: "+current.examDetails);
            if(current.next != null) {
                current = current.next;
            }else {
                System.out.println("You have reached the last exam");
            }
        }
    }


    public void viewPreviousExam() {
        if (current == null) {
            System.out.println("No previous exams available.");
        } else {
            // TODO 4: Implement logic to move to the previous exam in the list and display it
            System.out.println("Previous exam: "+current.examDetails);
            if(current.prev != null){
                current = current.prev;
            } else{
                System.out.println("You have reached the last previous exam");
            }
        }
    }

    public void viewAllExamSchedule() {
        ExamNode temp = head;
        if (temp == null) {
            System.out.println("No exams scheduled.");
        } else {
            System.out.println("Exam Schedule:");
            while (temp != null) {
                System.out.println(temp.examDetails);
                temp = temp.next;
            }
        }
    }
}


