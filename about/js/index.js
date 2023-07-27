function hideModel() {
  let tipModel = document.getElementById('tipModel');
  tipModel.style.display = 'none';
}

window.onload = function () {
  let listContainer = document.getElementById('listContainer');
  let navContainer = document.getElementById('navContainer');
  let headerContainer = document.getElementById('header');
  let footerContainer = document.getElementById('footer');

  /*
   * 跳转新的链接
   **/
  function goToNewAddress(address) {
    if (address) {
      // window.location.href = address; // 当前页面打开
      window.open(address); // 打开新的页面
    } else {
      alert('未配置链接');
    }
  }

  function showTipFun(text) {
    let tipModelContent = document.getElementById('tipModelContent');
    tipModelContent.innerHTML = '';
    let tipModel = document.getElementById('tipModel');
    let $div = document.createElement('div');
    // const data = bookMarks.find(item => String(item.id) === String(id));
    $div.innerHTML = text;
    tipModelContent.appendChild($div);
    tipModel.style.display = 'block';
  }

  /*
   * 渲染地址列表
   **/
  function renderContainer(name) {
    listContainer.innerHTML = '';
    let marks = bookMarks[name]
    if (marks && marks.length) {
      if(marks.length >0){
        for (let i = 0; i < marks.length; i ++) {
          const item = marks[i];
            let $li = document.createElement('li');
            let $img = document.createElement('img');
            let $p = document.createElement('p');
            $img.src = item.icon || './img/default.webp';
            $p.innerText = item.text || '未知链接';
            $li.address = item.href;
            $li.className = 'list-item';
          
            $li.onclick = function () {
              goToNewAddress(this.address);
            };
            $li.onmouseover = function(){
              $p.title = item.text
            }
            $li.appendChild($img);
            $li.appendChild($p);
            if (item.text) {
              let $div = document.createElement('div');
              $div.className = 'list-item-tip';
              $div.descId = item.text;
              $div.onclick = function (e) {
                e.stopPropagation(); // 阻止冒泡
                e.preventDefault(); // 阻止默认事件
                showTipFun(item.text);
              };
              $li.appendChild($div);
            }
            listContainer.appendChild($li);
        }
      }else{
        let $li = document.createElement('li');
        let $img = document.createElement('img');
        let $p = document.createElement('p');
        $img.src = './img/empty.jpg';
        $p.innerText = `未配置“${name}”列表`;
        $li.className = 'list-empty';
        $li.appendChild($img);
        $li.appendChild($p);
        listContainer.appendChild($li);
      }
    } else {
      let $li = document.createElement('li');
      let $img = document.createElement('img');
      let $p = document.createElement('p');
      $img.src = './img/empty.jpg';
      $p.innerText = `未配置“${name}”列表`;
      $li.className = 'list-empty';
      $li.appendChild($img);
      $li.appendChild($p);
      listContainer.appendChild($li);
    }
  }

  /*
   * 渲染nav导航栏
   **/
  function renderNav() {
    if (navTexts && navTexts.length) {
      for (let i = 0; i < navTexts.length; i ++) {
        const item = navTexts[i];
        let $li = document.createElement('li');
        $li.id = item;
        $li.innerText = item;
        $li.className = 'nav-list-item';
        $li.onclick = function () {
          renderContainer(item);
          clearNavFocus();
          this.style.borderBottom = '5px solid #2283E2';
        };
        if (i === 0) {
          $li.style.borderBottom = '5px solid #2283E2';
        }
        navContainer.appendChild($li);
      }
      renderContainer(navTexts[0]);
    } else {
      alert('未配置链接地址列表');
    }
  }

  /*
   * 渲染nav导航栏 选中状态
   **/
  function clearNavFocus() {
    let divs = document.getElementsByClassName("nav-list-item");
    let len = divs.length;
    for(let i = 0; i < len; i++) {
      divs[i].style.borderBottom = 'none';
    }
  }

  /*
   * 初始化方法
   **/
  function initData() {
    renderNav();
    headerContainer.innerText = title;
    footerContainer.innerText = footer;
  };

  /*
   * 初始化方法调用
   **/
  initData();
}