webpackJsonp([22], {
	"4PjJ": function(e, t, a) {
		"use strict";
		Object.defineProperty(t, "__esModule", {
			value: !0
		});
		var l = {
				name: "SpreadCode",
				data: function() {
					return {
						total: 0,
						page: 1,
						size: 15,
						logining: !1,
						tableData: [],
						isShowEditDialog: !1,
						options: [],
						value: "",
						searchValue: "",
						searchType: "1"
					}
				},
				created: function() {
					this.getPageData()
				},
				filters: {
					typeName: function(e) {
						return 1 === e ? '<span style="color:green">仙玉充值</span>' : 2 === e ? '<span style="color:green">VIP特权</span>' :
							3 === e ? '<span style="color:green">小资礼包</span>' : 4 === e ? '<span style="color:green">土豪礼包</span>' : void 0
					},
					formatDate: function(e) {
						return e ? new Date(parseInt(e)).toLocaleString().replace(/:\d{1,2}$/, " ") : "无"
					}
				},
				methods: {
					setSize: function(e) {
						this.size = e, this.getPageData()
					},
					setPage: function(e) {
						this.page = e, this.getPageData()
					},
					getPageData: function() {
						var e = this,
							t = new FormData;
						t.append("PageNum", this.page), t.append("PageSize", this.size), t.append("Value1", this.searchType ? this.searchType :
							""), t.append("Value2", this.searchValue ? this.searchValue : ""), this.$http.post("/api/rechargeinfo", t).then(
							function(t) {
								200 == t.data.code ? (e.tableData = t.data.data.list, e.total = t.data.data.total) : e.$alert("数据请求失败",
									"提示", {
										confirmButtonText: "ok"
									})
							}).catch(function(e) {
							console.log(e)
						})
					},
					handleRowClick: function(e, t, a) {
						this.setCurRowChecked(e)
					},
					handleCheckedAllAndCheckedNone: function(e) {
						1 != e.length && this.$refs.list.setCurrentRow()
					},
					dialogClose: function() {
						this.$refs.editForm.resetFields()
					},
					rowEdit: function() {
						this.isShowEditDialog = !0
					},
					handleEdit: function() {
						var e = this;
						this.$refs.editForm.validate(function(t) {
							if (t) {
								e.logining = !0;
								var a = new FormData;
								a.append("Value1", e.formFileds.goodsid), a.append("Value2", e.formFileds.sum), e.$http.post(
									"/api/exchange", a).then(function(t) {
									200 == t.data.code ? (e.isShowEditDialog = !1, e.getPageData(), e.$message.success("推广码生成成功")) : e.$alert(
										"推广码生成失败", "提示", {
											confirmButtonText: "ok"
										}), e.logining = !1
								}).catch(function(e) {
									this.logining = !1, console.log(e)
								})
							}
						})
					},
					rowDel: function(e, t, a) {
						this.$message.warning("暂未实现")
					},
					setCurRowChecked: function(e) {
						this.$refs.list.clearSelection(), this.$refs.list.toggleRowSelection(e)
					}
				}
			},
			n = {
				render: function() {
					var e = this,
						t = e.$createElement,
						a = e._self._c || t;
					return a("div", [a("el-row", {
						attrs: {
							gutter: 10
						}
					}, [a("el-col", {
						attrs: {
							xs: 24,
							sm: 24,
							md: 10,
							lg: 10,
							xl: 10
						}
					}, [a("el-input", {
						staticClass: "input-with-select",
						attrs: {
							placeholder: "请输入内容"
						},
						model: {
							value: e.searchValue,
							callback: function(t) {
								e.searchValue = t
							},
							expression: "searchValue"
						}
					}, [a("el-select", {
						staticClass: "search-select",
						attrs: {
							slot: "prepend",
							placeholder: "请选择"
						},
						slot: "prepend",
						model: {
							value: e.searchType,
							callback: function(t) {
								e.searchType = t
							},
							expression: "searchType"
						}
					}, [a("el-option", {
						attrs: {
							label: "玩家账号",
							value: "1"
						}
					}), e._v(" "), a("el-option", {
						attrs: {
							label: "玩家ID",
							value: "2"
						}
					}), e._v(" "), a("el-option", {
						attrs: {
							label: "玩家名称",
							value: "3"
						}
					})], 1), e._v(" "), a("el-button", {
						attrs: {
							slot: "append",
							icon: "el-icon-search"
						},
						on: {
							click: function(t) {
								return e.getPageData()
							}
						},
						slot: "append"
					})], 1)], 1), e._v(" "), a("el-col", {
						attrs: {
							xs: 24,
							sm: 24,
							md: 14,
							lg: 14,
							xl: 14
						}
					}, [a("el-pagination", {
						attrs: {
							background: "",
							"page-sizes": [15, 30, 40, 50],
							"page-size": 15,
							total: this.total,
							layout: "prev, pager, next, sizes, total"
						},
						on: {
							"size-change": e.setSize,
							"current-change": e.setPage
						}
					})], 1)], 1), e._v(" "), a("el-table", {
						ref: "list",
						staticStyle: {
							width: "100%"
						},
						attrs: {
							data: e.tableData,
							border: "",
							stripe: "",
							"highlight-current-row": "",
							"default-sort": {
								prop: "outtime",
								order: "descending"
							}
						},
						on: {
							"row-click": e.handleRowClick,
							"select-all": e.handleCheckedAllAndCheckedNone,
							select: e.handleCheckedAllAndCheckedNone
						}
					}, [a("el-table-column", {
						attrs: {
							type: "selection",
							width: "45",
							align: "center"
						}
					}), e._v(" "), a("el-table-column", {
						attrs: {
							property: "erid",
							label: "订单号",
							width: "120"
						}
					}), e._v(" "), a("el-table-column", {
						attrs: {
							property: "playeracc",
							label: "玩家账号",
							width: "180"
						}
					}), e._v(" "), a("el-table-column", {
						attrs: {
							property: "roleid",
							label: "角色ID",
							width: "120"
						}
					}), e._v(" "), a("el-table-column", {
						attrs: {
							property: "buyroleName",
							label: "角色名称",
							width: "150"
						}
					}), e._v(" "), a("el-table-column", {
						attrs: {
							property: "type",
							label: "充值类型",
							width: "120"
						},
						scopedSlots: e._u([{
							key: "default",
							fn: function(t) {
								return [a("div", {
									domProps: {
										innerHTML: e._s(e.$options.filters.typeName(t.row.type))
									}
								})]
							}
						}])
					}), e._v(" "), a("el-table-column", {
						attrs: {
							property: "recharge",
							label: "充值金额",
							width: "150"
						}
					}), e._v(" "), a("el-table-column", {
						attrs: {
							property: "yuanbao",
							label: "仙玉数量",
							width: "150"
						}
					}), e._v(" "), a("el-table-column", {
						attrs: {
							property: "paytime",
							label: "充值时间",
							sortable: ""
						}
					})], 1)], 1)
				},
				staticRenderFns: []
			};
		var o = a("VU/8")(l, n, !1, function(e) {
			a("hr9W")
		}, "data-v-23c5dd58", null);
		t.default = o.exports
	},
	hr9W: function(e, t) {}
});
//# sourceMappingURL=22.a826b2d9ab0288c455fa.js.map
