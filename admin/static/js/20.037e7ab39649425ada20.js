webpackJsonp([20], {
	i56f: function(e, t) {},
	uXRB: function(e, t, a) {
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
						formFileds: {
							goodsid: "",
							sum: ""
						},
						rules: {
							goodsid: [{
								required: !0,
								message: "物品不能为空",
								trigger: "blur, change"
							}],
							sum: [{
								required: !0,
								message: "数量不能为空",
								trigger: "blur, change"
							}, {
								type: "number",
								message: "数量必须为数字"
							}]
						},
						tableData: [],
						isShowEditDialog: !1,
						options: [],
						value: "",
						searchValue: "",
						searchType: "1"
					}
				},
				created: function() {
					var e = this;
					this.getPageData(), this.$http.get("/api/goods").then(function(t) {
						if (200 == t.data.code)
							for (var a in t.data.data) e.options.push({
								label: a,
								value: t.data.data[a]
							});
						else e.$alert("数据请求失败", "提示", {
							confirmButtonText: "ok"
						})
					}).catch(function(e) {
						console.log(e)
					})
				},
				filters: {
					flagName: function(e) {
						return 0 === e ? '<span style="color:green">未使用</span>' : 1 === e ? '<span style="color:red">已使用</span>' :
							void 0
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
							""), t.append("Value2", this.searchValue ? this.searchValue : ""), this.$http.post("/api/exchanges", t).then(
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
			o = {
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
					}, [a("el-button", {
						attrs: {
							type: "primary"
						},
						on: {
							click: function(t) {
								return e.rowEdit()
							}
						}
					}, [e._v("生成推广码")]), e._v(" "), a("el-input", {
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
							label: "推广码",
							value: "1"
						}
					}), e._v(" "), a("el-option", {
						attrs: {
							label: "商品ID",
							value: "2"
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
							property: "goodsguid",
							label: "卡号",
							width: "320"
						}
					}), e._v(" "), a("el-table-column", {
						attrs: {
							property: "goodsid",
							label: "商品名称",
							width: "180"
						}
					}), e._v(" "), a("el-table-column", {
						attrs: {
							property: "flag",
							label: "是否使用",
							width: "120"
						},
						scopedSlots: e._u([{
							key: "default",
							fn: function(t) {
								return [a("div", {
									domProps: {
										innerHTML: e._s(e.$options.filters.flagName(t.row.flag))
									}
								})]
							}
						}])
					}), e._v(" "), a("el-table-column", {
						attrs: {
							property: "outtime",
							label: "使用时间",
							width: "200",
							sortable: ""
						},
						scopedSlots: e._u([{
							key: "default",
							fn: function(t) {
								return [a("i", {
									staticClass: "el-icon-time"
								}), e._v(" "), a("span", {
									staticStyle: {
										"margin-left": "5px"
									}
								}, [e._v(e._s(e._f("formatDate")(t.row.outtime)))])]
							}
						}])
					}), e._v(" "), a("el-table-column", {
						attrs: {
							label: "操作",
							align: "center"
						},
						scopedSlots: e._u([{
							key: "default",
							fn: function(t) {
								return [a("el-button", {
									attrs: {
										circle: "",
										icon: "el-icon-delete",
										type: "danger",
										title: "删除",
										size: "small"
									},
									on: {
										click: function(a) {
											return e.rowDel(t.$index, t.row, a)
										}
									}
								})]
							}
						}])
					})], 1), e._v(" "), a("el-dialog", {
						attrs: {
							title: "生成推广码",
							visible: e.isShowEditDialog,
							width: "430px"
						},
						on: {
							"update:visible": function(t) {
								e.isShowEditDialog = t
							},
							close: e.dialogClose
						}
					}, [a("el-form", {
						ref: "editForm",
						attrs: {
							model: e.formFileds,
							"label-width": "120px",
							rules: e.rules
						}
					}, [a("el-form-item", {
						attrs: {
							label: "选择兑换物品",
							prop: "goodsid"
						}
					}, [a("el-select", {
						attrs: {
							filterable: "",
							placeholder: "可输入搜索"
						},
						model: {
							value: e.formFileds.goodsid,
							callback: function(t) {
								e.$set(e.formFileds, "goodsid", t)
							},
							expression: "formFileds.goodsid"
						}
					}, e._l(e.options, function(e) {
						return a("el-option", {
							key: e.value,
							attrs: {
								label: e.label,
								value: e.value
							}
						})
					}), 1)], 1), e._v(" "), a("el-form-item", {
						attrs: {
							label: "数量",
							prop: "sum"
						}
					}, [a("el-input", {
						model: {
							value: e.formFileds.sum,
							callback: function(t) {
								e.$set(e.formFileds, "sum", e._n(t))
							},
							expression: "formFileds.sum"
						}
					})], 1), e._v(" "), a("el-form-item", [a("el-button", {
						staticClass: "pull-right margin-l-10",
						on: {
							click: function(t) {
								e.isShowEditDialog = !1
							}
						}
					}, [e._v("取消")]), e._v(" "), a("el-button", {
						staticClass: "pull-right",
						attrs: {
							type: "primary",
							loading: e.logining
						},
						on: {
							click: function(t) {
								return e.handleEdit()
							}
						}
					}, [e._v("生成推广码")])], 1)], 1)], 1)], 1)
				},
				staticRenderFns: []
			};
		var i = a("VU/8")(l, o, !1, function(e) {
			a("i56f")
		}, "data-v-284acfc5", null);
		t.default = i.exports
	}
});
//# sourceMappingURL=20.037e7ab39649425ada20.js.map
