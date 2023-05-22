const loginButton = document.querySelector("#login-button");
const url =
  "http://ec2-13-125-237-143.ap-northeast-2.compute.amazonaws.com:8080";

function getDbStatus() {
  fetch(`${url}/status`, {
    method: "GET",
    credentials: "include",
    headers: {
      Authorization: `Bearer ${localStorage.getItem("accessToken")}`,
    },
  })
    .then((response) => {
      return response.json();
    })
    .then((data) => {
      console.log(data);
      const { connectedToDatabase } = data;
      if (connectedToDatabase) {
        window.location.href = "./success.html";
      } else window.location.href = "./alert.html";
    });
}

loginButton.addEventListener("click", (event) => {
  event.preventDefault();

  const username = document.querySelector('input[name="username"]').value;
  const password = document.querySelector('input[name="password"]').value;

  // 아래 주소를 개인 EC2 주소로 변경합니다.
  fetch(`${url}/signin`, {
    method: "POST",
    credentials: "include",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({
      username: username,
      password: password,
    }),
  })
    .then((response) => {
      if (response.ok) {
        console.log("로그인 성공!");
        return response.text();
      } else {
        alert("이름과 비밀번호를 정확히 입력해주세요!");
        throw new Error("로그인 실패");
      }
    })
    .then((text) => {
      localStorage.setItem("accessToken", text);
      getDbStatus();
    })
    .catch((err) => {
      console.error(err);
    });
});
