webpackJsonp([15], {
	DKMx: function(e, t, a) {
		"use strict";
		Object.defineProperty(t, "__esModule", {
			value: !0
		});
		var l = a("mvHQ"),
			i = a.n(l),
			c = (a("eNfa"), a("VsUZ")),
			o = {
				data: function() {
					return {
						tableData: [],
						showDialog: !1,
						showDialogNew: !1,
						chongjipack: {
							id: 0,
							packtype: 0,
							packgradetype: 0,
							packgrade: "",
							packgoods: "",
							getnumber: "",
							canpaymoney: ""
						},
						chongjipack2: {
							id: 0,
							packtype: 1,
							packgradetype: 0,
							packgrade: "",
							packgoods: "",
							getnumber: 1,
							canpaymoney: 0
						}
					}
				},
				methods: {
					coverPacktype: function(e, t) {
						return 1 == e[t.property] ? "新手礼包" : 2 == e[t.property] ? "小资冲级礼包" : 3 == e[t.property] ? "豪华冲级礼包" : 4 == e[t
							.property] ? "每日充值" : 5 == e[t.property] ? "连充" : 6 == e[t.property] ? "每日特惠" : "未知礼包"
					},
					handleEdit: function(e, t) {
						this.chongjipack.id = t.id, this.chongjipack.packtype = t.packtype, this.chongjipack.packgradetype = t.packgradetype,
							this.chongjipack.packgrade = t.packgrade, this.chongjipack.packgoods = t.packgoods, this.chongjipack.getnumber =
							t.getnumber, this.chongjipack.canpaymoney = t.canpaymoney, this.showDialog = !0
					},
					handleDelete: function(e, t) {
						var a = this,
							l = {
								id: t.id,
								type: "del"
							};
						Object(c.d)(l).then(function(e) {
							200 == e.status ? (a.$message.success("操作成功"), a.initData()) : a.$message.error("失败")
						})
					},
					addChongjipack: function() {
						this.showDialogNew = !1;
						var e = this,
							t = {
								chongjipack: i()(this.chongjipack2),
								type: "insert"
							};
						Object(c.d)(t).then(function(t) {
							200 == t.status ? (e.$message.success("操作成功"), e.initData()) : e.$message.error("失败")
						})
					},
					editChongjipack: function() {
						this.showDialog = !1;
						var e = this,
							t = {
								chongjipack: i()(this.chongjipack),
								type: "update"
							};
						Object(c.d)(t).then(function(t) {
							200 == t.status ? (e.$message.success("操作成功"), e.initData()) : e.$message.error("失败")
						})
					},
					initData: function() {
						var e = this;
						Object(c.l)({}).then(function(t) {
							400 == t.status ? e.$message.error(t.message) : 200 == t.status ? e.tableData = t.list : e.$message.warning(
								"未知错误")
						})
					}
				},
				mounted: function() {
					this.initData()
				}
			},
			n = {
				render: function() {
					var e = this,
						t = e.$createElement,
						a = e._self._c || t;
					return a("div", [a("div", {
						staticClass: "cm-title"
					}, [e._v("新增礼包")]), e._v(" "), a("div", {
						staticClass: "link-top"
					}), e._v(" "), a("div", {
						staticClass: "cm-search-div"
					}, [a("el-tag", [e._v("\n     礼包等级为显示在游戏中的文字，礼包级别，根据不同的礼包类型，有不同的含义，大多礼包，这个才代表真正领取礼包需要的等级\n    ")]), e._v(
						" "), a("br"), e._v(" "), a("el-tag", {
						attrs: {
							type: "danger",
							effect: "dark"
						}
					}, [e._v("\n    注意!注意!注意!，新增数据时，确保ID每次会自动+1,但是请确保其不会重复，否则一旦删除和修改，会将重复ID的数据一起删除或一起修改。\n    ")]), e._v(
						"\n         "), a("el-button", {
						attrs: {
							type: "primary",
							size: "small",
							icon: "el-icon-circle-plus"
						},
						on: {
							click: function(t) {
								e.showDialogNew = !0
							}
						}
					}, [e._v("新增礼包")])], 1), e._v(" "), a("div", {
						staticClass: "cm-title"
					}, [e._v("礼包内容")]), e._v(" "), a("div", {
						staticClass: "link-top"
					}), e._v(" "), a("br"), e._v(" "), a("div", [a("el-table", {
						attrs: {
							data: e.tableData,
							"header-cell-style": {
								textAlign: "center"
							},
							"cell-style": {
								textAlign: "center"
							},
							border: "",
							stripe: ""
						}
					}, [a("el-table-column", {
						attrs: {
							prop: "id",
							label: "礼包ID",
							width: "100"
						}
					}), e._v(" "), a("el-table-column", {
						attrs: {
							prop: "packtype",
							label: "礼包类型",
							width: "300",
							formatter: e.coverPacktype
						}
					}), e._v(" "), a("el-table-column", {
						attrs: {
							prop: "packgrade",
							label: "领取等级"
						}
					}), e._v(" "), a("el-table-column", {
						attrs: {
							prop: "packgoods",
							label: "领取物品"
						}
					}), e._v(" "), a("el-table-column", {
						attrs: {
							prop: "getnumber",
							label: "领取次数"
						}
					}), e._v(" "), a("el-table-column", {
						attrs: {
							prop: "canpaymoney",
							label: "需要支付的金额"
						}
					}), e._v(" "), a("el-table-column", {
						attrs: {
							prop: "huitime",
							label: "异动时间"
						}
					}), e._v(" "), a("el-table-column", {
						attrs: {
							label: "操作"
						},
						scopedSlots: e._u([{
							key: "default",
							fn: function(t) {
								return [a("el-button", {
									attrs: {
										size: "mini"
									},
									on: {
										click: function(a) {
											return e.handleEdit(t.$index, t.row)
										}
									}
								}, [e._v("编辑")]), e._v(" "), a("el-button", {
									attrs: {
										size: "mini",
										type: "danger"
									},
									on: {
										click: function(a) {
											return e.handleDelete(t.$index, t.row)
										}
									}
								}, [e._v("删除")])]
							}
						}])
					})], 1)], 1), e._v(" "), a("el-dialog", {
						attrs: {
							title: "礼包修改",
							visible: e.showDialog,
							width: "400px"
						},
						on: {
							"update:visible": function(t) {
								e.showDialog = t
							}
						}
					}, [a("el-form", {
						attrs: {
							model: e.chongjipack,
							size: "mini"
						}
					}, [a("el-form-item", {
						attrs: {
							label: "id",
							"label-width": "150px"
						}
					}, [a("el-input", {
						attrs: {
							disabled: !0
						},
						model: {
							value: e.chongjipack.id,
							callback: function(t) {
								e.$set(e.chongjipack, "id", t)
							},
							expression: "chongjipack.id"
						}
					})], 1), e._v(" "), a("el-form-item", {
						attrs: {
							label: "礼包类型",
							"label-width": "150px"
						}
					}, [a("el-select", {
						attrs: {
							placeholder: "请选择"
						},
						model: {
							value: e.chongjipack.packtype,
							callback: function(t) {
								e.$set(e.chongjipack, "packtype", t)
							},
							expression: "chongjipack.packtype"
						}
					}, [a("el-option", {
						attrs: {
							label: "新手礼包",
							value: 1
						}
					}), e._v(" "), a("el-option", {
						attrs: {
							label: "小资冲级礼包",
							value: 2
						}
					}), e._v(" "), a("el-option", {
						attrs: {
							label: "豪华冲级礼包",
							value: 3
						}
					}), e._v(" "), a("el-option", {
						attrs: {
							label: "每日充值",
							value: 4
						}
					}), e._v(" "), a("el-option", {
						attrs: {
							label: "连充",
							value: 5
						}
					}), e._v(" "), a("el-option", {
						attrs: {
							label: "每日特惠",
							value: 6
						}
					})], 1)], 1), e._v(" "), a("el-form-item", {
						attrs: {
							label: "礼包级别",
							"label-width": "150px"
						}
					}, [a("el-input", {
						model: {
							value: e.chongjipack.packgradetype,
							callback: function(t) {
								e.$set(e.chongjipack, "packgradetype", t)
							},
							expression: "chongjipack.packgradetype"
						}
					})], 1), e._v(" "), a("el-form-item", {
						attrs: {
							label: "领取等级",
							"label-width": "150px"
						}
					}, [a("el-input", {
						model: {
							value: e.chongjipack.packgrade,
							callback: function(t) {
								e.$set(e.chongjipack, "packgrade", t)
							},
							expression: "chongjipack.packgrade"
						}
					})], 1), e._v(" "), a("el-form-item", {
						attrs: {
							label: "领取的物品",
							"label-width": "150px"
						}
					}, [a("el-input", {
						model: {
							value: e.chongjipack.packgoods,
							callback: function(t) {
								e.$set(e.chongjipack, "packgoods", t)
							},
							expression: "chongjipack.packgoods"
						}
					})], 1), e._v(" "), a("el-form-item", {
						attrs: {
							label: "当前礼包领取次数",
							"label-width": "150px"
						}
					}, [a("el-input", {
						model: {
							value: e.chongjipack.getnumber,
							callback: function(t) {
								e.$set(e.chongjipack, "getnumber", t)
							},
							expression: "chongjipack.getnumber"
						}
					})], 1), e._v(" "), a("el-form-item", {
						attrs: {
							label: "获取需要支付的金额",
							"label-width": "150px"
						}
					}, [a("el-input", {
						model: {
							value: e.chongjipack.canpaymoney,
							callback: function(t) {
								e.$set(e.chongjipack, "canpaymoney", t)
							},
							expression: "chongjipack.canpaymoney"
						}
					})], 1), e._v(" "), a("el-form-item", {
						attrs: {
							label: "异动时间",
							"label-width": "150px"
						}
					}, [a("el-input", {
						model: {
							value: e.chongjipack.huitime,
							callback: function(t) {
								e.$set(e.chongjipack, "huitime", t)
							},
							expression: "chongjipack.huitime"
						}
					})], 1)], 1), e._v(" "), a("div", {
						staticClass: "dialog-footer",
						attrs: {
							slot: "footer"
						},
						slot: "footer"
					}, [a("el-button", {
						on: {
							click: function(t) {
								e.showDialog = !1
							}
						}
					}, [e._v("取 消")]), e._v(" "), a("el-button", {
						attrs: {
							type: "primary"
						},
						on: {
							click: function(t) {
								return e.editChongjipack()
							}
						}
					}, [e._v("确 定")])], 1)], 1), e._v(" "), a("el-dialog", {
						attrs: {
							title: "新增礼包",
							visible: e.showDialogNew,
							width: "400px"
						},
						on: {
							"update:visible": function(t) {
								e.showDialogNew = t
							}
						}
					}, [a("el-form", {
						attrs: {
							model: e.chongjipack2,
							size: "mini"
						}
					}, [a("el-form-item", {
						attrs: {
							label: "礼包类型",
							"label-width": "150px"
						}
					}, [a("el-select", {
						attrs: {
							placeholder: "请选择"
						},
						model: {
							value: e.chongjipack2.packtype,
							callback: function(t) {
								e.$set(e.chongjipack2, "packtype", t)
							},
							expression: "chongjipack2.packtype"
						}
					}, [a("el-option", {
						attrs: {
							label: "新手礼包",
							value: 1
						}
					}), e._v(" "), a("el-option", {
						attrs: {
							label: "小资冲级礼包",
							value: 2
						}
					}), e._v(" "), a("el-option", {
						attrs: {
							label: "豪华冲级礼包",
							value: 3
						}
					}), e._v(" "), a("el-option", {
						attrs: {
							label: "每日充值",
							value: 4
						}
					}), e._v(" "), a("el-option", {
						attrs: {
							label: "连充",
							value: 5
						}
					}), e._v(" "), a("el-option", {
						attrs: {
							label: "每日特惠",
							value: 6
						}
					})], 1)], 1), e._v(" "), a("el-form-item", {
						attrs: {
							label: "礼包级别",
							"label-width": "150px"
						}
					}, [a("el-input", {
						model: {
							value: e.chongjipack2.packgradetype,
							callback: function(t) {
								e.$set(e.chongjipack2, "packgradetype", t)
							},
							expression: "chongjipack2.packgradetype"
						}
					})], 1), e._v(" "), a("el-form-item", {
						attrs: {
							label: "领取等级",
							"label-width": "150px"
						}
					}, [a("el-input", {
						model: {
							value: e.chongjipack2.packgrade,
							callback: function(t) {
								e.$set(e.chongjipack2, "packgrade", t)
							},
							expression: "chongjipack2.packgrade"
						}
					})], 1), e._v(" "), a("el-form-item", {
						attrs: {
							label: "领取的物品",
							"label-width": "150px"
						}
					}, [a("el-input", {
						model: {
							value: e.chongjipack2.packgoods,
							callback: function(t) {
								e.$set(e.chongjipack2, "packgoods", t)
							},
							expression: "chongjipack2.packgoods"
						}
					})], 1), e._v(" "), a("el-form-item", {
						attrs: {
							label: "当前礼包领取次数",
							"label-width": "150px"
						}
					}, [a("el-input", {
						model: {
							value: e.chongjipack2.getnumber,
							callback: function(t) {
								e.$set(e.chongjipack2, "getnumber", t)
							},
							expression: "chongjipack2.getnumber"
						}
					})], 1), e._v(" "), a("el-form-item", {
						attrs: {
							label: "获取需要支付的金额",
							"label-width": "150px"
						}
					}, [a("el-input", {
						model: {
							value: e.chongjipack2.canpaymoney,
							callback: function(t) {
								e.$set(e.chongjipack2, "canpaymoney", t)
							},
							expression: "chongjipack2.canpaymoney"
						}
					})], 1), e._v(" "), a("el-form-item", {
						attrs: {
							label: "异动时间",
							"label-width": "150px"
						}
					}, [a("el-input", {
						model: {
							value: e.chongjipack2.huitime,
							callback: function(t) {
								e.$set(e.chongjipack2, "huitime", t)
							},
							expression: "chongjipack2.huitime"
						}
					})], 1)], 1), e._v(" "), a("div", {
						staticClass: "dialog-footer",
						attrs: {
							slot: "footer"
						},
						slot: "footer"
					}, [a("el-button", {
						on: {
							click: function(t) {
								e.showDialogNew = !1
							}
						}
					}, [e._v("取 消")]), e._v(" "), a("el-button", {
						attrs: {
							type: "primary"
						},
						on: {
							click: function(t) {
								return e.addChongjipack()
							}
						}
					}, [e._v("确 定")])], 1)], 1)], 1)
				},
				staticRenderFns: []
			};
		var p = a("VU/8")(o, n, !1, function(e) {
			a("HZ2N")
		}, "data-v-5261a8c5", null);
		t.default = p.exports
	},
	HZ2N: function(e, t) {}
});
//# sourceMappingURL=15.ca6e0dd915806347ae45.js.map
