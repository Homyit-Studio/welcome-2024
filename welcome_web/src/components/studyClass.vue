<script setup>
</script>

<template>
  <div class="main">
    <div class="wrapper">
      <div class="container">
        <input type="radio" name="slide" id="c1" checked>
        <label for="c1" class="card">
          <div class="row">
            <div class="description">
              <p>前端是演员和灯光师,利用HTML、CSS和JavaScript渲染页面,处理交互,确保用户体验流畅。灯光师（前端工程师）调整视觉效果,确保演出吸引人。</p>
            </div>
          </div>
        </label>
        <input type="radio" name="slide" id="c2">
        <label for="c2" class="card">
          <div class="row">
            <div class="description">
              <p>后端是导演和编剧,设计数据库、处理业务逻辑,确保系统正常运作,支持前端的请求响应。虽然用户看不到后端的工作,但它是整个系统运作的关键。</p>
            </div>
          </div>
        </label>
        <input type="radio" name="slide" id="c3">
        <label for="c3" class="card">
          <div class="row">
            <div class="description">
              <p>UI设计师负责产品的视觉效果,精心策划每个细节,营造完美氛围,让用户享受视觉上的愉悦。</p>
            </div>
          </div>
        </label>
      </div>
    </div>
  </div>
</template>

<style scoped>
.main {
  padding-top: 60px;
}

* {
  box-sizing: border-box;
  margin: 0;
  padding: 0;
  font-family: Arial, Helvetica, sans-serif;
}

.wrapper {
  width: 100%;
  margin: 0 auto;
  display: flex;
  align-items: center;
  justify-content: center;
}

.container {
  height: 400px;
  display: flex;
  flex-wrap: nowrap;
  justify-content: start;
  overflow-x: auto;
}

.card {
  flex: 0 0 auto;
  width: 80px;
  background-size: cover;
  cursor: pointer;
  overflow: hidden;
  border-radius: 0.8rem;
  margin: 0 10px;
  display: flex;
  align-items: flex-end;
  transition: .6s cubic-bezier(.28, -0.03, 0, .99);
  box-shadow: 0px 10px 30px -5px rgba(0, 0, 0, 0.3);
}

.card>.row {
  color: black;
  display: flex;
  flex-wrap: nowrap;
}

.card>.row>.icon {
  background: #fff;
  color: gray;
  border-radius: 50%;
  width: 50px;
  display: flex;
  justify-content: center;
  align-items: center;
  margin: 15px;
}

.card>.row>.description {
  display: flex;
  justify-content: center;
  flex-direction: column;
  overflow: hidden;
  height: 110px;
  width: 520px;
  opacity: 0;
  transform: translateY(30px);
  transition-delay: .3s;
  transition: all .3s ease;
}

.description p {
  color: #585858;
  font-size: 13px;
  padding: 10px 7px 10px 0px;
  line-height: 1.8;
  margin-left: 10%;
}

input {
  display: none;
}

input:checked+label {
  width: 600px;
}

input:checked+label .description {
  opacity: 1 !important;
  transform: translateY(0) !important;
}

.card[for="c1"] {
  background: url('./src/assets/about1.jpg') no-repeat;
  background-size: 600px 400px;
}

.card[for="c2"] {
  background: url('./src/assets/about2.jpg') no-repeat;
  background-size: 600px 400px;
}

.card[for="c3"] {
  background: url('./src/assets/about3.jpg') no-repeat;
  background-size: 600px 400px;
}

@media screen and (min-width:380px) {
  input:checked+label {
    width: 298px;
  }

  .container {
    height: 298px;
  }

  .description p {
    font-size: 12px;
    padding-bottom: 30px;
    height: 100px;
    font-weight: 700;
  }

  .card {
    width: 40px;
    border-radius: 0.5rem;
    margin: 0 2px;
  }

  .card>.row>.icon {
    width: 25px;
    height: 40px;
    border-radius: 50%;
    margin: 8px;
  }

  .card>.row>.description {
    width: 280px;
    height: 90px;
    opacity: 0;
  }

  input:checked+label .description {
    opacity: 1 !important;
    transform: translateY(0) !important;
  }

  .card[for="c1"] {
    background-size: 298px 298px;
  }

  .card[for="c2"] {
    background-size: 298px 298px;
  }

  .card[for="c3"] {
    background-size: 298px 298px;
  }
}

@media screen and (min-width:750px) {
  input:checked+label {
    width: 588px;
  }

  .container {
    height: 588px;
  }

  .description p {
    font-size: 18px;
    padding-bottom: 30px;
    height: 120px;
    font-weight: 700;
  }

  .card {
    width: 79px;
    border-radius: 0.6rem;
    margin: 0 4px;
  }

  .card>.row>.icon {
    width: 49px;
    height: 40px;
    border-radius: 50%;
    margin: 8px;
  }

  .card>.row>.description {
    width: 519px;
    height: 120px;
    margin-bottom: 20px;
    opacity: 0;
  }

  input:checked+label .description {
    opacity: 1 !important;
    transform: translateY(0) !important;
  }

  .card[for="c1"] {
    background-size: 588px 588px;
  }

  .card[for="c2"] {
    background-size: 588px 588px;
  }

  .card[for="c3"] {
    background-size: 588px 588px;
  }
}

@media screen and (min-width:1200px) {
  input:checked+label {
    width: 800px;
  }

  .container {
    height: 800px;
  }

  .description p {
    font-size: 22px;
    padding-bottom: 30px;
    height: 150px;
    font-weight: 700;
  }

  .card {
    width: 126px;
    border-radius: 0.7rem;
    margin: 0 6px;
  }

  .card>.row>.description {
    width: 705px;
    height: 150px;
    margin-bottom: 30px;
    opacity: 0;
  }

  input:checked+label .description {
    opacity: 1 !important;
    transform: translateY(0) !important;
  }

  .card[for="c1"] {
    background-size: 800px 800px;
  }

  .card[for="c2"] {
    background-size: 800px 800px;
  }

  .card[for="c3"] {
    background-size: 800px 800px;
  }
}</style>