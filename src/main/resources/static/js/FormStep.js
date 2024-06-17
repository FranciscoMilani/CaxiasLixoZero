$(document).ready(function() {
    let currentStep = 0;
    const $steps = $(".step");
    const $progressBarSteps = $(".progress-bar-step");
    showStep(currentStep);

    function showStep(step) {
        $steps.each(function(index) {
            $(this).toggle(index === step);
        });

        $progressBarSteps.each(function(index) {
            $(this).toggleClass("active-step", index === step);
        });
    }

    function nextPrev(n) {
        const steps = $(".step");
        if (n >= 1 && !validateForm()) return false;

        steps.eq(currentStep).css("display", "none");

        currentStep += n;
        // if (currentStep >= steps.length) {
        //     $("#regForm").submit();
        //     return false;
        // }

        showStep(currentStep);
    }

    function validateForm() {
        let valid = true;

        /*"input, select, textarea"*/
        $(".step").eq(currentStep).find("[required]").each(function() {
            if (!this.checkValidity()) {
                $(this).addClass("is-invalid");
                valid = false;
            }

            $(this).on("input change", function() {
                if ($(this).val().trim() !== "" || $(this).val() !== null ) {
                    $(this).removeClass("is-invalid");
                }
            });

            // if (/*$(this).prop("required") &&*/ $(this).val().trim() == "" ||  $(this).val() === null) {
            //     $(this).addClass("is-invalid");
            //     valid = false;
            // } else {
            //     $(this).removeClass("is-invalid");
            // }
        });

        if (valid) {
            $(".step").eq(currentStep).addClass("finish");
        }

        return valid;
    }
    // function gotoStep(stepNum) {
    //     nextPrev(+stepNum);
    // }

    $(document).on('click', '.btn-next', function() {
        nextPrev(1);
    });

    $(document).on('click', '.btn-prev', function() {
        nextPrev(-1);
    });

    //  $("[required]").on("input change", function() {
    //     if ($(this).val().trim() !== "" && $(this).val() !== null) {
    //         $(this).removeClass("is-invalid");
    //     }
    // });

    // $(document).on('click', '.progress-bar-step', function() {
    //     let index = $(this).index();
    //     console.log($(this).index)
    //     gotoStep(index);
    // });
});


