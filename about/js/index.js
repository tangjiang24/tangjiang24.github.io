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

  function showTipFun(id) {
    let tipModelContent = document.getElementById('tipModelContent');
    tipModelContent.innerHTML = '';
    let tipModel = document.getElementById('tipModel');
    let $div = document.createElement('div');
    const data = addressList.find(item => String(item.id) === String(id));
    $div.innerHTML = data.desc;
    tipModelContent.appendChild($div);
    tipModel.style.display = 'block';
  }

  /*
   * 渲染地址列表
   **/
  function renderContainer(id, name) {
    listContainer.innerHTML = '';
    if (addressList && addressList.length) {
      let empty = true;
      for (let i = 0; i < addressList.length; i ++) {
        const item = addressList[i];
        if (String(id) === String(item.parentId)) {
          empty = false;
          let $li = document.createElement('li');
          let $img = document.createElement('img');
          let $p = document.createElement('p');
          $img.src = item.imgUrl || './img/default.webp';
          $p.innerText = item.name || '未知链接';
          $li.address = item.address;
          $li.className = 'list-item';
          $li.onclick = function () {
            goToNewAddress(this.address);
          };
          $li.appendChild($img);
          $li.appendChild($p);
          if (item.desc) {
            let $div = document.createElement('div');
            $div.className = 'list-item-tip';
            $div.descId = item.id;
            $div.onclick = function (e) {
              e.stopPropagation(); // 阻止冒泡
              e.preventDefault(); // 阻止默认事件
              showTipFun(this.descId);
            };
            $li.appendChild($div);
          }
          listContainer.appendChild($li);
        }
      }
      if (empty) {
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
    if (navList && navList.length) {
      for (let i = 0; i < navList.length; i ++) {
        const item = navList[i];
        let $li = document.createElement('li');
        $li.id = item.id;
        $li.innerText = item.name;
        $li.className = 'nav-list-item';
        $li.onclick = function () {
          renderContainer(this.id, this.innerText);
          clearNavFocus();
          this.style.borderBottom = '5px solid #2283E2';
        };
        if (i === 0) {
          $li.style.borderBottom = '5px solid #2283E2';
        }
        navContainer.appendChild($li);
      }
      renderContainer(navList[0].id, navList[0].name);
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