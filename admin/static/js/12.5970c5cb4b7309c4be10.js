webpackJsonp([12], {
	"8G9q": function(t, e) {},
	rIjk: function(t, e, r) {
		"use strict";
		Object.defineProperty(e, "__esModule", {
			value: !0
		});
		var s = {
			render: function() {
				var t = this.$createElement,
					e = this._self._c || t;
				return e("div", {
					staticClass: "wrapper"
				}, [e("div", {
					staticClass: "main"
				}, [e("el-button", {
					staticClass: "btn btn-return J-page-return",
					on: {
						click: this.goBack
					}
				}, [this._v("上一页")]), this._v(" "), e("router-link", {
					attrs: {
						to: "/"
					}
				}, [e("el-button", {
					staticClass: "btn btn-refresh J-page-refresh"
				}, [this._v("首页")])], 1)], 1)])
			},
			staticRenderFns: []
		};
		var n = r("VU/8")({
			name: "Error",
			methods: {
				goBack: function() {
					this.$router.go(-1)
				}
			}
		}, s, !1, function(t) {
			r("8G9q")
		}, "data-v-5f3e0f63", null);
		e.default = n.exports
	}
});
//# sourceMappingURL=12.5970c5cb4b7309c4be10.js.map
