webpackJsonp([17], {
	Qnig: function(t, e, a) {
		"use strict";
		Object.defineProperty(e, "__esModule", {
			value: !0
		});
		var n = a("spLH"),
			s = (a("eNfa"), a("VsUZ")),
			l = {
				name: "comment",
				components: {
					pagination: n.a
				},
				data: function() {
					return {
						Id: "",
						sum: "",
						Rolename: "",
						tableData: [],
						pager: {
							totalCount: 0,
							currentPage: 1,
							pageSize: 20
						}
					}
				},
				methods: {
					addGoods: function() {
						var t = this,
							e = {
								Id: this.Id,
								sum: this.sum,
								tag: (new Date).getTime(),
								Rolename: this.Rolename
							};
						Object(s.a)(e).then(function(e) {
							t.$message.success("操作成功"), t.initData()
						})
					},
					initData: function() {
						var t = this;
						Object(s.n)({
							type: "4",
							count: 40
						}).then(function(e) {
							t.tableData = e.list
						})
					}
				},
				mounted: function() {
					this.initData()
				}
			},
			i = {
				render: function() {
					var t = this,
						e = t.$createElement,
						a = t._self._c || e;
					return a("div", [a("div", {
						staticClass: "cm-title"
					}, [t._v("物品发送")]), t._v(" "), a("div", {
						staticClass: "link-top"
					}), t._v(" "), a("div", {
						staticClass: "cm-search-div"
					}, [t._v("\n    角色名："), a("el-input", {
						staticClass: "cm-search-input",
						attrs: {
							placeholder: "请输入角色名"
						},
						model: {
							value: t.Rolename,
							callback: function(e) {
								t.Rolename = e
							},
							expression: "Rolename"
						}
					}), t._v("\n    物品ID："), a("el-input", {
						staticClass: "cm-search-input",
						attrs: {
							placeholder: "请输入物品ID"
						},
						model: {
							value: t.Id,
							callback: function(e) {
								t.Id = e
							},
							expression: "Id"
						}
					}), t._v("\n    物品数量："), a("el-input", {
						staticClass: "cm-search-input",
						attrs: {
							placeholder: "物品数量"
						},
						model: {
							value: t.sum,
							callback: function(e) {
								t.sum = e
							},
							expression: "sum"
						}
					}), t._v(" "), a("el-button", {
						attrs: {
							type: "success",
							size: "small",
							icon: "el-icon-s-promotion"
						},
						on: {
							click: function(e) {
								t.pager.currentPage = 1, t.addGoods()
							}
						}
					}, [t._v("发送")])], 1), t._v(" "), a("div", {
						staticClass: "cm-title"
					}, [t._v("充值记录")]), t._v(" "), a("div", {
						staticClass: "link-top"
					}), t._v(" "), a("br"), t._v(" "), a("div", [a("el-table", {
						attrs: {
							data: t.tableData,
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
							prop: "recordId",
							label: "充值ID",
							width: "100"
						}
					}), t._v(" "), a("el-table-column", {
						attrs: {
							prop: "text",
							label: "充值记录",
							width: "600"
						}
					}), t._v(" "), a("el-table-column", {
						attrs: {
							prop: "recordTime",
							label: "充值时间"
						}
					})], 1)], 1), t._v(" "), a("pagination", {
						staticClass: "cm-page",
						attrs: {
							pager: t.pager
						},
						on: {
							load: function(t) {}
						}
					})], 1)
				},
				staticRenderFns: []
			};
		var c = a("VU/8")(l, i, !1, function(t) {
			a("k3n6")
		}, "data-v-484e4f1c", null);
		e.default = c.exports
	},
	k3n6: function(t, e) {}
});
//# sourceMappingURL=17.64b409bcb61a43cb862a.js.map
