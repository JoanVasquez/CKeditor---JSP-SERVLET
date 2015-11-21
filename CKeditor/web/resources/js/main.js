
/* global CKEDITOR, self */
/*
 * whatsapp: 1-809-978-5552
 kakaotalk: joanvasquez
 email: yoloprogramo22@gmail.com
 */
(function () {
    self.AjaxProccess = function (elements) {
        this.elements = elements;
        this.data_to_send = {};
    };

    self.AjaxProccess.prototype = {
        ajax_proccess: function () {
            var reference = this;
            this.data_to_send["info"] = this.elements[0];

            $.ajax({
                data: reference.data_to_send,
                url: "information.co",
                type: "post",
                dataType: "json",
                encode: true,
                cache: false,
                success: function (data) {
                    if (data.hasOwnProperty("success")) {
                        window.location = "display.jsp";
                    } else {
                        console.log(data.error);
                    }
                }
            });
        }

    };
})();

$(document).on("ready", function () {
    $("#information").on("submit", function (event) {
        event.preventDefault();
        var elements = [CKEDITOR.instances['content'].getData()];
        new AjaxProccess(elements).ajax_proccess();
    });
});
