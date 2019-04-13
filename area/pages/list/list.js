Page({

  /**
   * 页面的初始数据
   */
  data: {
    list: []
  },

  getData() {
    wx.request({
      url: 'http://localhost:8082/demoa/superadmin/listarea',
      method: 'get',
      data: {},
      success: (res) => {
        const list = res.data.areaList;
        if (list === null) {
          const toastText = 'get data failed' + res.data.errMsg;
          wx.showToast({
            title: toastText,
            icon: '',
            duration: 2000
          });
        } else {
          this.setData({
            list
          })
        }
      }
    })
  },

  addArea() {
    wx.navigateTo({
      url: '../operation/operation',
    })
  },
  deleteArea(e) {
    wx.showModal({
      title: '提示',
      content: `确定要删除[${e.target.dataset.areaname}]吗？`,
      success: (sm) => {
        if(sm.confirm) {
          wx.request({
            url: 'http://localhost:8082/demoa/superadmin/deleteareabyid',
            method: 'get',
            data: {
              areaId: Number(e.target.dataset.areaid)
            },
            success: (res) => {
              const result = res.data.success;
              let toastText = result ? '删除成功' : '删除失败';
              result && this.getData();
              wx.showToast({
                title: toastText,
                icon: '',
                duration: 2000
              })
            }
          })
        }
      }
    })
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow() {
    this.getData();
  },
})