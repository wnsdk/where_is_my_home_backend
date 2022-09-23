function regist() {
  // 각 form 의 input 에 입력된 값들을 css 선택자를 이용하여 가져오기
  let id = document.getElementById("id").value;
  let password = document.getElementById("password").value;
  let email = document.getElementById("email").value;
  let name = document.getElementById("name").value;
  let phone = document.getElementById("phone").value;

  // 입력값 검증
  if (!id || !password || !email || !name || !phone) {
    alert("빈칸이 없도록 입력해주세요.");
    return;
  } else {
    // user 생성
    const user = {
      id: id,
      password: password,
      email: email,
      name: name,
      phone: phone,
    };

    // user 객체 문자열로 바꿔서 로컬스토리지에 저장
    localStorage.setItem(id, JSON.stringify(user));
    alert("사용자 등록 성공!");
    // 로그인 화면으로 돌아가기
    location.replace("login.html");
  }
  // user 정보 출력
  //console.log(user);
}

function login() {
  // 문서에서 id로 input data 가져오기
  let id = document.getElementById("id").value;
  
  let password = document.getElementById("password").value;

  // 로컬스토리지에 "user" 키로 저장된 item 가져와서 json 객체로 만들기
  const user = JSON.parse(localStorage.getItem(id));
  
  // 입력값 검증
  if (user && user.id === id && user.password === password) {
    
    alert("로그인 성공 !");

    sessionStorage.setItem("loginCheck", id);
    // 로그인 성공하면 index 페이지로 이동.
    location.replace("index.html");
  } else {
    alert("로그인 실패 !");
  }
}

function logout() {
  alert("로그아웃");

  sessionStorage.removeItem("loginCheck");
  location.replace("index.html");
}

function modify(){
  localStorage.removeItem(sessionStorage.getItem("loginCheck"));

  // 각 form 의 input 에 입력된 값들을 css 선택자를 이용하여 가져오기
  let id = document.getElementById("id").value;
  let password = document.getElementById("password").value;
  let email = document.getElementById("email").value;
  let name = document.getElementById("name").value;
  let phone = document.getElementById("phone").value;

  // 입력값 검증
  if (!id || !password || !email || !name || !phone) {
    alert("빈칸이 없도록 입력해주세요.");
    return;
  } else {
    // user 생성
    const user = {
      id: id,
      password: password,
      email: email,
      name: name,
      phone: phone,
    };

    // user 객체 문자열로 바꿔서 로컬스토리지에 저장
    localStorage.setItem(id, JSON.stringify(user));
    sessionStorage.setItem("loginCheck", id);
    alert("정보 수정 완료!");
    // 로그인 화면으로 돌아가기
    location.replace("info.html");
  }
}

function delete_info(){
  localStorage.removeItem(sessionStorage.getItem("loginCheck"));
  sessionStorage.removeItem("loginCheck");
  location.replace("index.html");

  alert("회원 탈퇴 완료");
}

function find(){
  let id = document.getElementById("id").value;
  let name = document.getElementById("name").value;
  let email = document.getElementById("email").value;

  // 로컬스토리지에 "user" 키로 저장된 item 가져와서 json 객체로 만들기
  const user = JSON.parse(localStorage.getItem(id));
  
  // 입력값 검증
  if (user && user.id === id && user.name === name && user.email == email) {
    
    alert(email +"로 비밀번호 메일이 전송되었습니다.");

    location.replace("login.html");
  } else {
    alert("비밀번호 찾기 실패 !");
  }
}

let date = new Date();

window.onload = function () {

  if(document.querySelector("#year")){
    let yearEl = document.querySelector("#year");
    let yearOpt = `<option value="">매매년도선택</option>`;
    let year = date.getFullYear();
    for (let i = year; i > year - 20; i--) {
      yearOpt += `<option value="${i}">${i}년</option>`;
    }
    yearEl.innerHTML = yearOpt;
    // 브라우저가 열리면 시도정보 얻기.
    sendRequest("sido", "*00000000");
  }
  



  if (sessionStorage.getItem("loginCheck")) {
    document.getElementById("navbar1").style.display = "none";
    document.getElementById("navbar2").style.display = "";
  } else {
    document.getElementById("navbar1").style.display = "";
    document.getElementById("navbar2").style.display = "none";
  }

  if (document.querySelector("#user-info")) {
    const user = JSON.parse(localStorage.getItem(sessionStorage.getItem("loginCheck")));
    console.log(user.id);

    let user_div = document.querySelector("#user-info");
    let item = `
    <form>
          <h1 class="h3 mb-3 fw-normal">회원 정보 확인</h1>
  
          <div class="form-floating mb-1">
            <input type="text" class="form-control" id="id" value="${user.id}">
            <label for="id">ID</label>
          </div>
          <div class="form-floating mb-1">
            <input type="password" class="form-control" id="password" value="${user.password}">
            <label for="password">Password</label>
          </div>
          <div class="form-floating mb-1">
            <input type="email" class="form-control" id="email" value="${user.email}">
            <label for="email">email</label>
          </div>
          <div class="form-floating mb-1">
            <input type="text" class="form-control" id="name" value="${user.name}">
            <label for="name">name</label>
          </div>
          <div class="form-floating mb-3">
            <input type="number" class="form-control" id="phone" value="${user.phone}">
            <label for="phone">phone</label>
          </div>
          <button class="w-100 btn btn-lg btn-primary mb-1" onclick="modify()" type="button">정보 수정</button>
          <button class="w-100 btn btn-lg btn-primary" onclick="delete_info()" type="button">회원 탈퇴</button>
        </form>
  `;
    user_div.innerHTML = item;
  }
};

if(document.querySelector("#year")){
  document.querySelector("#year").addEventListener("change", function () {
    let month = date.getMonth() + 1;
    let monthEl = document.querySelector("#month");
    let monthOpt = `<option value="">매매월선택</option>`;
    let yearSel = document.querySelector("#year");
    let m = yearSel[yearSel.selectedIndex].value == date.getFullYear() ? month : 13;
    for (let i = 1; i < m; i++) {
      monthOpt += `<option value="${i < 10 ? "0" + i : i}">${i}월</option>`;
    }
    monthEl.innerHTML = monthOpt;
  });
}


if(document.querySelector("#sido")){
  document.querySelector("#sido").addEventListener("change", function () {
    if (this[this.selectedIndex].value) {
      let regcode = this[this.selectedIndex].value.substr(0, 2) + "*00000";
      sendRequest("gugun", regcode);
    } else {
      initOption("gugun");
      initOption("dong");
    }
  });
}
// 시도가 바뀌면 구군정보 얻기.

if(document.querySelector("#gugun")) {
// 구군이 바뀌면 동정보 얻기.
document.querySelector("#gugun").addEventListener("change", function () {
  if (this[this.selectedIndex].value) {
    let regcode = this[this.selectedIndex].value.substr(0, 5) + "*";
    sendRequest("dong", regcode);
  } else {
    initOption("dong");
  }
});
}


function sendRequest(selid, regcode) {
  const url = "https://grpc-proxy-server-mkvo6j4wsq-du.a.run.app/v1/regcodes";
  let params = "regcode_pattern=" + regcode + "&is_ignore_zero=true";
  fetch(`${url}?${params}`)
    .then((response) => response.json())
    .then((data) => addOption(selid, data));
}

function addOption(selid, data) {
  let opt = ``;
  initOption(selid);
  switch (selid) {
    case "sido":
      opt += `<option value="">시도선택</option>`;
      data.regcodes.forEach(function (regcode) {
        opt += `
          <option value="${regcode.code}">${regcode.name}</option>
          `;
      });
      break;
    case "gugun":
      opt += `<option value="">구군선택</option>`;
      for (let i = 0; i < data.regcodes.length; i++) {
        if (i != data.regcodes.length - 1) {
          if (
            data.regcodes[i].name.split(" ")[1] == data.regcodes[i + 1].name.split(" ")[1] &&
            data.regcodes[i].name.split(" ").length !=
            data.regcodes[i + 1].name.split(" ").length
          ) {
            data.regcodes.splice(i, 1);
            i--;
          }
        }
      }
      let name = "";
      data.regcodes.forEach(function (regcode) {
        if (regcode.name.split(" ").length == 2) name = regcode.name.split(" ")[1];
        else name = regcode.name.split(" ")[1] + " " + regcode.name.split(" ")[2];
        opt += `
          <option value="${regcode.code}">${name}</option>
          `;
      });
      break;
    case "dong":
      opt += `<option value="">동선택</option>`;
      let idx = 2;
      data.regcodes.forEach(function (regcode) {
        if (regcode.name.split(" ").length != 3) idx = 3;
        opt += `
          <option value="${regcode.code}">${regcode.name.split(" ")[idx]}</option>
          `;
      });
  }
  document.querySelector(`#${selid}`).innerHTML = opt;
}

function initOption(selid) {
  let options = document.querySelector(`#${selid}`);
  options.length = 0;
  // let len = options.length;
  // for (let i = len - 1; i >= 0; i--) {
  //   options.remove(i);
  // }
}

///////////////////////// 아파트 매매 정보 /////////////////////////
if(document.querySelector("#list-btn")){

  document.querySelector("#list-btn").addEventListener("click", function () {
    let url =
      "http://openapi.molit.go.kr/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTradeDev";
    let gugunSel = document.querySelector("#gugun");
    let regCode = gugunSel[gugunSel.selectedIndex].value.substr(0, 5);
    let yearSel = document.querySelector("#year");
    let year = yearSel[yearSel.selectedIndex].value;
    let monthSel = document.querySelector("#month");
    let month = monthSel[monthSel.selectedIndex].value;
    let dealYM = year + month;
    let queryParams =
      encodeURIComponent("serviceKey") + "=" + "j%2F7v2Q5W39Nh4oejDwd4mkq3lO9wTHFrd%2FB%2Fn1J6ajwftzTfWCvDpiABRuQaDQ2JN61BGWmaR3LemZVqub4y7Q%3D%3D"; /*Service Key*/
    queryParams +=
      "&" +
      encodeURIComponent("LAWD_CD") +
      "=" +
      encodeURIComponent(regCode); /*아파트소재 구군*/
    queryParams +=
      "&" + encodeURIComponent("DEAL_YMD") + "=" + encodeURIComponent(dealYM); /*조회년월*/
    queryParams +=
      "&" + encodeURIComponent("pageNo") + "=" + encodeURIComponent("1"); /*페이지번호*/
    queryParams +=
      "&" + encodeURIComponent("numOfRows") + "=" + encodeURIComponent("9999"); /*페이지당건수*/
  
    fetch(`${url}?${queryParams}`)
      .then((response) => response.text())
      .then((data) => makeList(data));
  });
}


function makeList(data) {
  document.querySelector("table").setAttribute("style", "display: ;");
  let tbody = document.querySelector("#aptlist");
  let parser = new DOMParser();
  const xml = parser.parseFromString(data, "application/xml");
  // console.log(xml);
  initTable();
  let apts = xml.querySelectorAll("item");
  apts.forEach((apt) => {
    let tr = document.createElement("tr");

    let nameTd = document.createElement("td");
    nameTd.appendChild(document.createTextNode(apt.querySelector("아파트").textContent));
    tr.appendChild(nameTd);

    let floorTd = document.createElement("td");
    floorTd.appendChild(document.createTextNode(apt.querySelector("층").textContent));
    tr.appendChild(floorTd);

    let areaTd = document.createElement("td");
    areaTd.appendChild(document.createTextNode(apt.querySelector("전용면적").textContent));
    tr.appendChild(areaTd);

    let dongTd = document.createElement("td");
    dongTd.appendChild(document.createTextNode(apt.querySelector("법정동").textContent));
    tr.appendChild(dongTd);

    let priceTd = document.createElement("td");
    priceTd.appendChild(
      document.createTextNode(apt.querySelector("거래금액").textContent + "만원"),
    );
    priceTd.classList.add("text-end");
    tr.appendChild(priceTd);

    tbody.appendChild(tr);
  });
}

function initTable() {
  let tbody = document.querySelector("#aptlist");
  let len = tbody.rows.length;
  for (let i = len - 1; i >= 0; i--) {
    tbody.deleteRow(i);
  }
}
