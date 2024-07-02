//초기데이터 선언
let basicDatas = [
  { id: 1, title: "Todo 1", done: false },
  { id: 2, title: "Todo 2", done: true },
];
const deleteTodo = (id) => {
  basicDatas = basicDatas.filter((todo) => todo.id != id);
};
const addTodoItem = (todoObj) => {
  let ulTag = document.getElementById("todo-item-list");
  let liTag = document.createElement("li");
  liTag.className = "todo-item";

  const textSpan = document.createElement("SPAN");
  textSpan.className = "todo-text";
  const todoText = document.createTextNode(todoObj.title);

  textSpan.appendChild(todoText);
  liTag.appendChild(textSpan);
  liTag.setAttribute("id", todoObj.id);
  ulTag.appendChild(liTag);

  if (todoObj.done) {
    textSpan.classList.toggle("checked");
  }

  //삭제버튼과 이벤트 추가

  const removeSpan = document.createElement("SPAN");
  const removeText = document.createTextNode("\u00D7");
  removeSpan.className = "remove";
  removeSpan.appendChild(removeText);
  liTag.appendChild(removeSpan);
  removeSpan.addEventListener("click", (el) => {
    el.stopImmediatePropagation();
    let thisLi = el.target.parentElement;
    deleteTodo(thisLi.getAttribute("id"));
    console.log(thisLi.getAttribute("id"));
    console.log(basicDatas);
    thisLi.remove();
  });
};

//초기데이터를 화면에 보여주는 함수
const getTodos = () => {
  basicDatas.forEach(addTodoItem);
};
getTodos();

//입력받은 Todo를 basicDatas 배열에 추가하고 화면에도 추가하도록 하는 함수
const postTodo = (todoTitle) => {
  const newTodo = { id: basicDatas.length + 1, title: todoTitle, done: false };
  basicDatas.push(newTodo);
  addTodoItem(newTodo);
};

//추가버튼이 클릭되었을때 todo 1건이 추가되도록 이벤트작성

const inputBtn = document.querySelector(".add-button");
inputBtn.addEventListener("click", () => {
  let value = document.getElementById("myInput").value;
  console.log(value);
  if (value == "") {
    alert("할일을 적어주세요");
    return;
  }
  postTodo(value);
  document.querySelector("#myInput").value = "";
});

//엔터키
const myInput = document.getElementById("myInput");
myInput.addEventListener("keydown", (evnet) => {
  let value = document.getElementById("myInput").value;
  if (event.key == "Enter") {
    console.log(value);
    if (value == 0) {
      alert("할일을 적어주세요");
      return;
    }
    postTodo(value);
    document.querySelector("#myInput").value = "";
  }
});

//업데이트하는 함수

const updateTodo = (id) => {
  const todo = basicDatas.find((todo) => todo.id == id);
  if (todo) {
    todo.done = !todo.done;
  }
};

const ulTag = document.querySelector("#todo-item-list");
ulTag.addEventListener("click", (el) => {
  let text = el.target;
  if (el.target.tagName == "LI" || el.target.tagName == "SPAN") {
    if (el.target.tagName == "LI") {
      text = text.querySelector(".todo-text");
    }
    const liObj = text.parentElement;
    updateTodo(liObj.getAttribute("id"));
    text.classList.toggle("checked");
  }
});
