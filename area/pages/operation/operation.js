Page({

  /**
   * 页面的初始数据
   */
  data: {
    form: {
      areaId: '',
      areaName: '',
      priority: '',
    }
  },

  bindKeyInput(e) {
    const { detail, target } = e;
    Object.assign(this.data.form, {
      [target.dataset.key]: detail.value
    })
  },

  validateForm() {
    const { areaName, priority } = this.data.form;
    let toastText = ''
    if (areaName === '') {
      toastText = '区域名不能为空';
      wx.showToast({
        title: toastText,
        icon: '',
        duration: 2000
      })
      return true;
    } else if (priority === '') {
      toastText = '优先级不能为空';
      wx.showToast({
        title: toastText,
        icon: '',
        duration: 2000
      })
      return true;
    }
    return false;
  },

  submit() {
    if (this.validateForm()) {
      return false;
    }

    wx.request({
      url: 'http://localhost:8082/demoa/superadmin/addOrUpdateArea',
      method: 'post',
      data: this.data.form,
      success: (res) => {
        console.log(res)
        let toastText = res.success ? '编辑信息成功' : '编辑信息失败'
        wx.showToast({
          title: toastText,
          icon: '',
          duration: 2000
        });
        wx.navigateTo({
          url: '../list/list'
        })
      }
    })
  },

  getData() {
    const { form } = this.data;
    wx.request({
      url: 'http://localhost:8082/demoa/superadmin/getareabyid',
      method: 'get',
      data: {
        areaId: Number(form.areaId)
      },
      success: (res) => {
        console.log(res)
        if (res.data.success) {
          const { areaId, areaName ,priority } = res.data.area;
          this.setData({
            form: {
              areaId,
              areaName,
              priority
            }
          })
        }
      }
    })
  },

  reset() {
    this.setData({
      form: {
        areaId: '',
        areaName: '',
        priority: '',
      }
    })
  },

  onLoad(option) {
    if (option.areaId) {
      Object.assign(this.data.form, {
        areaId: option.areaId
      })
      this.getData();
    }
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
    
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {
    
  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {
    
  },
})